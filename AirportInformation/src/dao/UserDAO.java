package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import beans.UserBean;
import util.DBUtil;

/**
 * 회원가입, 회원탈퇴, 회원수정, 로그인 기능, 내정보 보기
 */
public class UserDAO {
	private static UserDAO instance;
	
	private UserDAO() {}
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	/**
	 * 회원가입
	 * @throws SQLException 
	 */
	public static void userInsert(UserBean udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO users VALUES(?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getId());
			pstmt.setString(2, udo.getPwd());
			pstmt.setString(3, udo.getName());
			pstmt.setString(4, udo.getEmail());
			
			pstmt.executeUpdate(); // 쿼리 실행
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
			con = DBUtil.getConnection();
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
	public static void userUpdate(UserBean udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE users SET password = ? , email = ? WHERE id = ?";
		try {
			con = DBUtil.getConnection();

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
	public static boolean userLogin(String id) throws SQLException {
		String pass = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT id, pw FROM users WHERE id = ?";
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				new UserBean(rset.getString(1), rset.getString(2));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return false;
	} 

	/**
	 * 내정보 보기
	 * @throws SQLException 
	 */
	public static void userInfo(UserBean udo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM users WHERE id = ? ";
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, udo.getId());
			rset = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
