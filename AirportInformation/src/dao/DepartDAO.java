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
	public static void searchDepartAir(DepartDTO adt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM departInfo";
		
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
	
	/** 출발날짜 검색 
	 * @throws SQLException */
	public static ArrayList<String> searchDepartDate(String airport) throws SQLException {
		ArrayList<String> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT dscheduledatetime FROM departinfo WHERE airport = ?";
		
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
