package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/user")
public class UserService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		String command = request.getParameter("command");

		if (command.equals("join")) {
			insert(request, response);
		} else if (command.equals("delete")) {
			delete(request, response);
		} else if (command.equals("login")) {
			login(request, response);
		}
	}// end of service

	/**
	 * 회원 가입 메소드
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();

		UserBean dto = new UserBean(id, pwd, name, email);
		String url = null;

		try {
			UserDAO.userInsert(dto);
			request.setAttribute("dto", dto);
			url = "mypage.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", "입력 실패");
			url = "error.jsp";
		}

		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
	} // end of insert

	/**
	 * 회원 탈퇴 메소드
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String email = request.getParameter("email").trim();
		String url = null;
		try {
			UserDAO.userDelete(id, email);
			url = "index.jsp";
		} catch (SQLException e) {
			request.setAttribute("error", "입력 실패");
			url = "error.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	} // end of delete

	/**
	 * 로그인 메소드
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		String url = null;

		try {
			UserDAO.userLogin(id); 
			url = "mypage.jsp";
		} catch (SQLException e) {
			request.setAttribute("error", "입력 실패");
			url = "error.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	} // end of login

} // end of class
