package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import dto.BookingInfoDTO;
import util.DBUtil;

public class BookingInfoDAO {
	private static BookingInfoDAO bookinginfoDAO;
	private static DataSource source = null;

	public BookingInfoDAO() {}
	public static BookingInfoDAO getInstance() {
		if (bookinginfoDAO == null) {
			bookinginfoDAO = new BookingInfoDAO();
		}
		return bookinginfoDAO;
	}
	
	/**
	 * 예약정보 확인
	 * @param bto
	 */
	public static void searchBooking(BookingInfoDTO bto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM bookingInfo WHERE = ?";
		
		try {
			con = source.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bto.getId());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
}
