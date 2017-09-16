package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingInfoDAO;

@WebServlet("/booking")
public class BookingService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		bookingInfo(request, response);
		
	} // end of service
	
	
	public void bookingInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String DFlightID = request.getParameter("departList").trim();
		String DScheduledateTime = request.getParameter("departDate").trim();
		String AFlightID = request.getParameter("arrivalList").trim();
		String AScheduledateTime = request.getParameter("arrivalDate").trim();
	
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
