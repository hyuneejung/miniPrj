package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import main.Main;
import util.InputUtil;
import util.MiniConn;

public class MemberController {

	public int join() {

		EcoDto dto = showJoinView();

		Connection conn = MiniConn.getConnection();

		String sql = "INSERT INTO ECO_MEMBER (NAME, NICK, GENDER, ID, PWD, PHONE, BANK, ACCOUNT) VALUES (?,?,?,?,?,?,?,?)";

		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getNick());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getPwd());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getBank());
			pstmt.setString(8, dto.getAccount());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			e.printStackTrace();
		}
		return result;
	}

	private EcoDto showJoinView() {

		EcoDto memberdto = new EcoDto();

		Scanner sc = new Scanner(System.in);

			System.out.println("\n가입하실 정보를 입력해 주세요.");
			System.out.println("\n이름 : ");
			String name = sc.nextLine();
			System.out.println("닉네임 : ");
			String nick = sc.nextLine();
			System.out.println("성별(F/M) : ");
			String gender = sc.nextLine();

			// 아이디 중복 확인
			System.out.println("아이디 : ");
			String id = sc.nextLine();

			System.out.println("비밀번호 : ");
			String pwd = sc.nextLine();

			// 핸드폰 번호 중복 확인
			System.out.println("핸드폰번호 : ");
			String phone = sc.nextLine();

			System.out.println("----- 은행 목록 -----");
			System.out.println("1.국민\n2.농협\n3.신한\n4.신협\n5.카카오");
			System.out.println("\n은행 : ");
			String bank = sc.nextLine();
			System.out.println("계좌번호 : ");
			String account = sc.nextLine();

			memberdto.setName(name);
			memberdto.setNick(nick);
			memberdto.setGender(gender);
			memberdto.setId(id);
			memberdto.setPwd(pwd);
			memberdto.setPhone(phone);
			memberdto.setBank(bank);
			memberdto.setAccount(account);

			return memberdto;
		
	}

}
