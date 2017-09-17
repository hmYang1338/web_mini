package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ArrivalBean;
import beans.DepartBean;
import dao.ArrivalDAO;
import dao.DepartDAO;

@WebServlet("/aircraft")
public class AircraftService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		getList(request, response);
		
	} // end of service

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
//			ArrayList<ArrivalBean> allList = ArrivalDAO.getArrival();
			ArrayList<DepartBean> allList = DepartDAO.getDepart();
			request.setAttribute("allList", allList);
//			request.setAttribute("allList2", allList2);
			
			System.out.println(allList);
//			System.out.println(allList2);
			url = "search.jsp";
		} catch (SQLException e) {
			request.setAttribute("error", "도착정보실패");
			url = "error.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
