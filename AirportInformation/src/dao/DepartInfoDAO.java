package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.DepartInfoDTO;
import util.DBUtil;

/** DB의 DepartInfo 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class DepartInfoDAO {
	/* 변수 */
	private static String sql;

	/* 함수 */
	public static int add(DepartInfoDTO di) {

		int result = 0; // 성공 여부를 저장할 변수
		Connection c = null;
		PreparedStatement ps = null;
		sql = "INSERT INTO departinfo VALUES(?,?,?,?)";

		try {
			// DB Connection을 생성하고 쿼리문 생성
			c = DBUtil.getConnection();

			ps = c.prepareStatement(sql);
			ps.setString(1, di.getDflightID());
			ps.setString(2, di.getDscheduleDateTime());
			ps.setString(3, di.getAirline());
			ps.setString(4, di.getAirport());

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
		sql = "DELETE FROM departinfo";
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
