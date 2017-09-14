package dao;

/**
 * 회원가입, 회원탈퇴, 회원수정, 로그인 기능, 내정보 보기
 */
public class UserDAO {
	private static UserDAO userDAO;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	/**
	 * 회원가입
	 */
	public void userInsert() {
	}

	/**
	 * 회원 탈퇴
	 */
	public void userDelete() {
	}

	/**
	 * 회원 수정
	 */
	public void userUpdate() {
	}

	/**
	 * 로그인
	 */
	public void userLogin() {
	} 

	/**
	 * 내정보 보기
	 */
	public void userInfo() {
	}

<<<<<<< HEAD
=======
	

>>>>>>> branch 'master' of https://github.com/hmYang1338/web_mini.git
}
