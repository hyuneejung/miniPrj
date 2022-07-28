package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MiniConn {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KH";
			String pwd = "KH";
			
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("커넥션 가져오기 실패");
			e.printStackTrace();
		}
		
		return conn;
		
	}

	public static void rollback(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void close(PreparedStatement pstmt, ResultSet result, Connection conn) {
		// TODO Auto-generated method stub
		
	}

}
