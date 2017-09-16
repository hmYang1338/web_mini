package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import beans.ArrivalBean;
import beans.DepartBean;
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
	public static HashMap searchArrivalAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArrivalBean> allList = new ArrayList<ArrivalBean>();
		ArrayList<String> timlist = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		String query = "SELECT DISTINCT airport FROM arrivalInfo order by airport";
		String query2 = "select distinct ASCHEDULEDATETIME from arrivalInfo where AIRPORT=";
		String tmp_time = "";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new ArrivalBean(rset.getString(1)));
			}
			
			for(ArrivalBean i : allList) {
				pstmt = con.prepareStatement(query2 + "'" + i.getAirport() + "'");
				rset = pstmt.executeQuery();
				tmp_time = "";
				while(rset.next()) {
					tmp_time += rset.getString(1);
				}
				timlist.add(tmp_time);
			}
			
			for(int i = 0; i < allList.size(); i++) {
				//System.out.println(allList.get(i).getAirport());
				//System.out.println(timlist.get(i));
				map.put(allList.get(i).getAirport(), timlist.get(i));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return map;
	}
	
	/**
	 * 도착항공편 조회
	 * @param adt
	 */
	public static ArrayList searchArrivalAir2() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArrivalBean> allList = new ArrayList<ArrivalBean>();
		String query = "SELECT DISTINCT airport FROM arrivalInfo order by airport";
		
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
