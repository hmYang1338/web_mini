package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aircraft")
public class AircraftService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");

		if (command.equals("join")) {
//			insert(request, response);
		} else if (command.equals("delete")) {
//			delete(request, response);
		}
	} // end of service

	public void searchDepartDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
