package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import beans.BookingInfoBean;
import util.DBUtil;

public class BookingInfoDAO {
	private static BookingInfoDAO bookinginfoDAO;

	public BookingInfoDAO() {}
	public static BookingInfoDAO getInstance() {
		if (bookinginfoDAO == null) {
			bookinginfoDAO = new BookingInfoDAO();
		}
		return bookinginfoDAO;
	}
	
	public static void insertBooking(BookingInfoBean bto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO bookinginfo VALUES(?,?,?,?,?,?)";
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bto.getBookingCode());
			pstmt.setString(2, bto.getId());
			pstmt.setString(3, bto.getAFlightID());
			pstmt.setString(4, bto.getAScheduledateTime());
			pstmt.setString(5, bto.getDFlightID());
			pstmt.setString(6, bto.getDScheduledateTime());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	
	/**
	 * 예약정보 확인
	 * @param bto
	 */
	public static void searchBooking(BookingInfoBean bto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM bookingInfo WHERE = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bto.getId());
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	}
	
}
