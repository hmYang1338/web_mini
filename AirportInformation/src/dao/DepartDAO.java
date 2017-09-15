package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

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
	public static ArrayList searchDepartAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DepartDTO> allList = new ArrayList<DepartDTO>();
		String query = "SELECT DISTINCT airport FROM departInfo";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				allList.add(new DepartDTO(rset.getString(1)));
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
		ArrayList<DepartDTO> list = new ArrayList<DepartDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT dscheduledatetime FROM departinfo";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new DepartDTO(rset.getString(1)));
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
