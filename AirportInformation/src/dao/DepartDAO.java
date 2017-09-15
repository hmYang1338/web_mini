package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dto.ArrivalDTO;
import dto.DepartDTO;
import util.DBUtil;

public class DepartDAO {
	private static DepartDAO departDAO;

	public DepartDAO() {}
	public static DepartDAO getInstance() {
		if (departDAO == null) {
			departDAO = new DepartDAO();
		}
		return departDAO;
	}

	/** 출발항공편 조회 */
	public static void searchDepartAir(DepartDTO adt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM departInfo";
	}
	
	/** 출발날짜 검색 
	 * @throws SQLException */
	public static void searchDepartDate(String airport) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT dscheduledatetime FROM departinfo WHERE airport = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, airport);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	}
}
