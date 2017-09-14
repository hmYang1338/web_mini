package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ArrivalInfoDTO;
import util.DBUtil;

public class ArrivalInfoDAO {
	/* 변수 */
	private static String sql;

	/* 함수 */
	public static int add(ArrivalInfoDTO ai) {

		int result = 0; // 성공 여부를 저장할 변수
		Connection c = null;
		PreparedStatement ps = null;
		sql = "INSERT INTO arrivalinfo VALUES(?,?,?,?)";

		try {
			// DB Connection을 생성하고 쿼리문 생성
			c = DBUtil.getConnection();

			ps = c.prepareStatement(sql);
			ps.setString(1, ai.getAflightID());
			ps.setString(2, ai.getAscheduleDateTime());
			ps.setString(3, ai.getAirline());
			ps.setString(4, ai.getAirport());

			// 쿼리문을 실행하고 그 결과를 저장
			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		return result;

	}// end of add
	
	/** departinfo 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {
		sql = "DELETE FROM arrivalinfo";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
	} // end of deleteAll()
}
