package savePoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cafe.CafeDto;
import util.InputUtil;
import util.MiniConn;

public class SavePointDao {
	
	public int dbAllTableAddCP(CafeDto dto) { //일회용 컵 반환 적립 시 회원테이블에 포인트 added포인트 업데이트
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ECO_MEMBER \r\n"
				+ "SET \r\n"
				+ "POINT = POINT + (SELECT CUPPOINT FROM CAFE WHERE NAME = ?)\r\n"
				+ ", ADDEDPOINT = ADDEDPOINT + (SELECT CUPPOINT FROM CAFE WHERE NAME = ?)\r\n"
				+ "WHERE ID = 'TAEWON'"; //아이디 부분 로그인 부분에서 받아올수 있게하기 
		String sql2 = "INSERT INTO HISTORY(NO, ID, POINT, REPORT) \r\n"
				+ "VALUES (SEQ_HISTORY_NO.NEXTVAL, \r\n"
				+ "'TAEWON'" //아이디 부분 로그인 부분에서 받아올 수 있게하기
				+ ", (SELECT CUPPOINT FROM CAFE WHERE NAME = ? ), '텀블러 사용' )";
		int result = 0;
		int result2 = 0;
		try {
			conn = MiniConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getName());
			
			result = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, dto.getName());
			
			result2 = pstmt.executeUpdate();
			
			if(result > 0 && result2 > 0) {
				MiniConn.commit(conn);
				return result+result2;
			} else {
				MiniConn.rollback(conn);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] 일회용 컵 반환 ECO적립 실패");
			e.printStackTrace();
		} finally {
			MiniConn.close(pstmt, conn);
		}
		return result+result2;
	}
	
	
	public int dbAllTableAddTP(CafeDto dto) { //텀블러포인트 적립 시 회원테이블에 포인트 added포인트 업데이트
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ECO_MEMBER \r\n"
				+ "SET \r\n"
				+ "POINT = POINT + (SELECT TUMPOINT FROM CAFE WHERE NAME = ?)\r\n"
				+ ", ADDEDPOINT = ADDEDPOINT + (SELECT TUMPOINT FROM CAFE WHERE NAME = ?)\r\n"
				+ "WHERE ID = 'TAEWON'"; //아이디 부분 로그인 부분에서 받아올수 있게하기 
		String sql2 = "INSERT INTO HISTORY(NO, ID, POINT, REPORT) \r\n"
				+ "VALUES (SEQ_HISTORY_NO.NEXTVAL, \r\n"
				+ "'TAEWON'" //아이디 부분 로그인 부분에서 받아올 수 있게하기
				+ ", (SELECT TUMPOINT FROM CAFE WHERE NAME = ? ), '텀블러 사용' )";
		int result = 0;
		int result2 = 0;
		try {
			conn = MiniConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getName());
			
			result = pstmt.executeUpdate();
			
			pstmt.setString(1, dto.getName());
			result2 = pstmt.executeUpdate();
			
			if(result > 0 && result2 > 0) {
				System.out.println(result+result2);
				MiniConn.commit(conn);
				return result+result2;
			} else {
				MiniConn.rollback(conn);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] 텁블러 사용 ECO적립 실패");
			e.printStackTrace();
		} finally {
			MiniConn.close(pstmt, conn);
		}
		return result+result2;
	}

	 
	
	public CafeDto setCafeMember(int cafeNo) { //카페고유번호 받아서 맞으면 객체 생성 틀리면 실패
		CafeDto dto = null;
		Connection conn = MiniConn.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM CAFE WHERE SECRETCODE = ?";
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cafeNo);
			result = pstmt.executeQuery();
			if(result.next()) {
				dto = new CafeDto();
				dto.setNo(result.getInt("NO"));
				dto.setName(result.getString("NAME"));
				dto.setCupPoint(result.getInt("CUPPOINT"));
				dto.setTumPoint(result.getInt("TUMPOINT"));
				dto.setSecretCode(cafeNo);
				return dto;
			}
		} catch (SQLException e) {
			System.out.println("제휴 까페가 아닙니다.");
			e.printStackTrace();
		} finally {
			MiniConn.close(pstmt, result, conn);
		}
		return dto;
	}
	
	public void cafeView() { ///~~~까페목록~~~

		Connection conn = MiniConn.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM CAFE";
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			System.out.println("순번\t카페이름\t\t컵반환금\t텀블러사용");
			while(result.next()) {
				System.out.println();
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3)+"\t"+result.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			MiniConn.rollback(conn);
		} finally {
			MiniConn.close(pstmt, result, conn);
		}

	}// cafeView



}// class
