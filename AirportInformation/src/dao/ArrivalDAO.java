package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dto.ArrivalDTO;
import util.DBUtil;

public class ArrivalDAO {
	private static ArrivalDAO arrivalDAO;
	private static DataSource source = null;
	
	private ArrivalDAO() {}
	public static ArrivalDAO getInstance() {
		if(arrivalDAO == null) {
			arrivalDAO = new ArrivalDAO();
		}
		return arrivalDAO;
	}
	
	/**
	 * 도착항공편 조회
	 * @param adt
	 */
	public static void searchArrivalAir(ArrivalDTO adt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM arrivalInfo";
		
		try {
			con = source.getConnection();
			
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void searchArrivalDate(String airport) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT dscheduledatetime FROM arrivalinfo WHERE airport = ?";
		
		/*try {
			con = source.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, airport);
			
		} catch {
			
		}*/
	}
	
}
