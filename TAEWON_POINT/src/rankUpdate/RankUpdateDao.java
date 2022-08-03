package rankUpdate;

import static util.MiniConn.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import member.EcoDto;

public class RankUpdateDao {
	/*
	 * 현재객체 added포인트 가져오기
	 * 
	 * ranksys테이블 기준치 확인
	 * 
	 *ranksys테이블 기준치 맞다면 자동 업데이트
	 * */
	public int rankUpdate(EcoDto ed, Connection conn) throws Exception {
		String sql = "UPDATE ECO_MEMBER SET RANKNO = (SELECT MAX(NO) FROM RANKSYS WHERE (SELECT ADDEDPOINT FROM ECO_MEMBER WHERE ID = ?) > MINPOINT) WHERE ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ed.getId());
			pstmt.setString(2, ed.getId());
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String changeRank(EcoDto ed, Connection conn) throws Exception {
		String sql = "";
		PreparedStatement pstmt = null;
		String rank = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
		} finally {
			close(pstmt);
		}
		return rank;
	}
}
