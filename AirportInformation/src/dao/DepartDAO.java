package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import beans.ArrivalBean;
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
	public static ArrayList searchDepartAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DepartBean> allList = new ArrayList<DepartBean>();
		String query = "SELECT DISTINCT airport FROM departInfo ORDER BY airport";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new DepartBean(rset.getString(1)));
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
