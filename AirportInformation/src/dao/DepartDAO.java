package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import beans.DepartBean;
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
	public static HashMap searchDepartAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DepartBean> allList = new ArrayList<DepartBean>();
		ArrayList<String> timlist = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		String query = "SELECT DISTINCT airport FROM departInfo ORDER BY airport";
		String query2 = "select distinct DSCHEDULEDATETIME from DEPARTINFO where AIRPORT=";
		String tmp_time = "";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new DepartBean(rset.getString(1)));
			}
			
			for(DepartBean i : allList) {
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
	
	/** 출발항공편 조회 */
	public static ArrayList searchDepartAir2() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DepartBean> allList = new ArrayList<DepartBean>();
		ArrayList<String> timlist = new ArrayList<String>();
		String query = "SELECT DISTINCT airport FROM departInfo ORDER BY airport";
		String query2 = "select distinct DSCHEDULEDATETIME from DEPARTINFO where AIRPORT=";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new DepartBean(rset.getString(1)));
			}
			
			for(DepartBean i : allList) {
				query2 += "'" + i.getAirport() + "'";
				System.out.println(query2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return allList;
	}
	
	/** 출발날짜 검색 
	 * @throws SQLException */
	public static ArrayList searchDepartDate() throws SQLException {
		ArrayList<DepartBean> list = new ArrayList<DepartBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT dscheduledatetime FROM departinfo";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new DepartBean(rset.getString(1)));
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
