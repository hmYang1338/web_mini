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
import dao.ArrivalDAO;
import dao.DepartDAO;

@WebServlet("/aircraft")
public class AircraftService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");

		if (command.equals("searcharrive")) {
			searchDepartDate(request, response);
		} else if (command.equals("searchdepart")) {
			searchArriveDate(request, response);
		}
	} // end of service

	/**
	 * 출발일시 찾기
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchDepartDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String airport = request.getParameter("airport").trim();
		ArrayList<String> list = null;
		try {
			list = DepartDAO.searchDepartDate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(list.toString()).forward(request, response);
	}

	/**
	 * 도착일시 찾기
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchArriveDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String airport = request.getParameter("airport").trim();
//		ArrayList<String> list = null;
//		try {
//			list = ArrivalDAO.searchArrivalDate(airport);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher(list.toString()).forward(request, response);
	
		ArrayList allList = ArrivalDAO.searchArrivalAir();
		request.setAttribute("allList", allList);
		
		RequestDispatcher rdp = request.getRequestDispatcher(allList.toString());
		rdp.forward(request, response);
	}
}
