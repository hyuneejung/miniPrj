package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import main.Main;
import util.InputUtil;
import util.MiniConn;

public class EcoControll {

	public EcoDto login(EcoDto data) {
		String id = data.getId();
		String pwd = data.getPwd();

		// 드라이버 등록
		// 드라이버 이용해서 연결 가져오기
		Connection conn = MiniConn.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// SQL 실행 --?
		String sql = "SELECT * FROM ECO_MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";

		EcoDto loginEco = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			// 지금 실행하는 쿼리는 ? SELECT 쿼리 -> 결과집합 (ResultSet)
			rs = pstmt.executeQuery();
			//
			if (rs.next()) {
				String name = rs.getString("NAME");
				String ecoid = rs.getString("ID");
				Timestamp enrolldate = rs.getTimestamp("ENROLL_DATE");

				loginEco = new EcoDto();

				loginEco.setId(ecoid);
				loginEco.setName(name);
				loginEco.setEnroll_date(enrolldate);

			}
		} catch (SQLException e) {
			System.out.println("로그인 오류입니다.");
			e.printStackTrace();
		} finally {
			MiniConn.close(conn);
			MiniConn.close(pstmt);
			MiniConn.close(rs);
		}
		// 로그인처리
		Main.LoginUser = loginEco;
		return loginEco;
	}

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요  : ");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 : ");
		String pwd = sc.nextLine();

		EcoDto dto = new EcoDto();
		dto.setId(id);
		dto.setPwd(pwd);

		// 로그인 처리
		login(dto);

		if (Main.LoginUser != null) {
			System.out.println("로그인에 성공하셨습니다.");
		} else {
			System.out.println("--로그인 실패--");
			System.out.println("아이디 / 비밀번호 를 다시 입력해주세요. ");
		}
	}// 로그인

	public void loginCheck(EcoDto dto) {
		if (dto != null) {
			System.out.println("<====사용자 정보====>");
			System.out.println(dto);
		} else {
			System.out.println("로그인실패");
		}

	}// 로긴 체크

	public String findId(String name, String phone) {

		Connection conn = MiniConn.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ID FROM ECO_MEMBER WHERE NAME = ? AND PHONE = ?";
		String getId = null;
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			rs.next();
			getId = rs.getString("ID");

		} catch (SQLException e) {
			System.out.println("ID 찾기 실패 에러");
			e.printStackTrace();
		} finally {
			MiniConn.close(rs);
			MiniConn.close(pstmt);
			MiniConn.close(conn);
		}
		return getId;

	}

	public void findUser() {

		System.out.print("이름 : ");
		String name = InputUtil.getString();
		System.out.print("전화번호 : ");
		String phone = InputUtil.getString();

		String rdn = InputUtil.randomNum(6, 1);
		System.out.println(" 인증번호 6자리 ::" + rdn);
		System.out.print("입력번호 ::::");

		String rdnCheck = InputUtil.getString();

		if (rdn.equals(rdnCheck)) {
			String getId = findId(name, phone);
			System.out.println("아이디를 찾았습니다 ! : " + getId);

		} else {
			System.out.println("인증번호가 일치하지않습니다.");
		}
	}

	public void changePwd2() {
		System.out.print("이름을 입력해주세요 ::");
		String name = InputUtil.getString();
		System.out.print("아이디를 입력해주세요 ::");
		String id = InputUtil.getString();
		System.out.print("전화번호를 입력해주세요::");
		String phone = InputUtil.getString();

		String rdn = InputUtil.randomNum(6, 1);
		System.out.println("인증번호 6자리를 입력하세요 ::::" + rdn);
		System.out.print("입력 인증번호 ::::");
		String rdnCheck = InputUtil.getString();

		if (rdnCheck.equals(rdn)) { // 인증번호 일치
			// 기존비밀번호가 맞는지 체크
			EcoDto dto = findInDb(name, id, phone);
			String pwdCheck = dto.getPwd();

			System.out.print("새로운 비밀번호를 입력해주세요 ::");
			String chPwd = InputUtil.getString();
			System.out.print("비밀번호를 한번더 입력해주세요");
			String chPwd2 = InputUtil.getString();

			if (chPwd.equals(chPwd2)) {

				if (chPwd.equals(pwdCheck)) {
					System.out.println("기존 비밀번호와 신규 비밀번호가 동일합니다.");
					// 비밀번호 일치
					
				}else {
				int r =	updatePwd(dto,id);
				if(r == 1) {
					System.out.println("비밀번호 변경이 완료되었습니다.");
				}else {
					System.out.println("비밀번호 변경 실패");
				}
				}
			} else {
				System.out.println("입력하신 비밀번호가 서로 일치하지않습니다.");
			}
		} // 인증번호 IF
		else {
			System.out.println("인증번호가 일치하지않습니다.");
		} // 인증번호 입력값이다를떄
	}// 비번변경

	public EcoDto findInDb(String name, String id, String phone) {
		// 기존 비밀번호(db)를 받아와야함
		// 데이터 베이스에있는 아이디의 비밀번호 작성

		EcoDto dto = null;
		Connection conn = MiniConn.getConnection();
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM ECO_MEMBER WHERE ID = ? AND NAME = ? AND PHONE = ?";

		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new EcoDto();
				dto.setId(rs.getString("ID"));
				dto.setName(rs.getString("NAME"));
				dto.setPhone(rs.getString("PHONE"));

				return dto;
			}

		} catch (SQLException e) {
			MiniConn.rollback(conn);

			e.printStackTrace();
		} finally {
			MiniConn.close(conn);
			MiniConn.close(pstmt);

		}
		return dto;

	}

	
	private int updatePwd(EcoDto dto, String newPwd) {

		
		
		Connection conn = MiniConn.getConnection();

		String sql = "UPDATE ECO_MEMBER SET PWD = ? WHERE ID = ?";

		PreparedStatement pstmt = null;
		int result = 0;

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, dto.getId()); // 여기에 dto.getId가 들어가야함.

			result = pstmt.executeUpdate();

			if (result == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			MiniConn.rollback(conn);

			e.printStackTrace();
		} finally {
			MiniConn.close(conn);
			MiniConn.close(pstmt);

		}
		return result;
	}

}