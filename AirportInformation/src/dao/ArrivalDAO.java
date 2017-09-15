package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.ArrivalDTO;
import util.DBUtil;

public class ArrivalDAO {
	private static ArrivalDAO arrivalDAO;
	
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
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	/** 도착날짜 검색 
	 * @throws SQLException */
	public static ArrayList<String> searchArrivalDate(String airport) throws SQLException {
		ArrayList<String> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT ascheduledatetime FROM arrivalinfo WHERE airport = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, airport);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(rset.getString("airport"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
