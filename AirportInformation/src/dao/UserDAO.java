package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import dto.UserDTO;
import util.DBUtil;

/**
 * 회원가입, 회원탈퇴, 회원수정, 로그인 기능, 내정보 보기
 */
public class UserDAO {
	private static UserDAO userDAO;
	private static DataSource source = null;
	
	private UserDAO() {}
	public static UserDAO getInstance() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	/**
	 * 회원가입
	 * @throws SQLException 
	 */
	public static void userInsert(UserDTO udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO users VALUES(?,?,?,?)";
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getId());
			pstmt.setString(2, udo.getPwd());
			pstmt.setString(3, udo.getName());
			pstmt.setString(4, udo.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	/**
	 * 회원 탈퇴
	 * @throws SQLException 
	 */
	public static void userDelete(String id, String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM users WHERE id = ? && email = ?";
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	/**
	 * 회원 수정
	 * @throws SQLException 
	 */
	public static void userUpdate(UserDTO udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE users SET password = ? , email = ? WHERE id = ?";
		try {
			con = source.getConnection();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getPwd());
			pstmt.setString(2, udo.getEmail());
			pstmt.setString(3, udo.getId());

			pstmt.executeQuery();

		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	/**
	 * 로그인
	 * @throws SQLException 
	 */
	public void userLogin(UserDTO udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT id, pwd FROM users WHERE id = ? ";
		try {
			con = source.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getId());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	} 

	/**
	 * 내정보 보기
	 * @throws SQLException 
	 */
	public void userInfo(UserDTO udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM users WHERE id = ? ";
		try {
			con = source.getConnection();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getId());

			pstmt.executeQuery();

		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
