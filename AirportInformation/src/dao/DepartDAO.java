package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import dto.ArrivalDTO;
import dto.DepartDTO;

public class DepartDAO {
	private static DepartDAO departDAO;
	private static DataSource source = null;

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
}
