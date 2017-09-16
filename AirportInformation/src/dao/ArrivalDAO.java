package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import beans.ArrivalBean;
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
	public static ArrayList searchArrivalAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArrivalBean> allList = new ArrayList<ArrivalBean>();
		String query = "SELECT DISTINCT airport FROM arrivalInfo";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new ArrivalBean(rset.getString(1)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allList;
	}
	
	/** 도착날짜 검색 
	 * @throws SQLException */
	public static ArrayList searchArrivalDate() throws SQLException {
		ArrayList<ArrivalBean> list = new ArrayList<ArrivalBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT ascheduledatetime FROM arrivalinfo";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new ArrivalBean(rset.getString(1)));
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
