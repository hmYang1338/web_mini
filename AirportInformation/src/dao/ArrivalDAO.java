package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import dto.ArrivalDTO;

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
	
	/** 도착항공편 조회 */
	public static void searchArrivalAir(ArrivalDTO adt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT ";
	}
}
