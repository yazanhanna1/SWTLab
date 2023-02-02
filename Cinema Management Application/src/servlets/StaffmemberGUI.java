package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CMApplication;

/**
 * Contains GUI for staffmember
 * 
 * @author swe.uni-due.de
 *
 */
public class StaffmemberGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the insertOffer form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "staffmember");
		request.setAttribute("pagetitle", "Insert Performance");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageS.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Contains handling of insertOffer call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "staffmember");

		// Check wether the call is insertOffer or not
		if (request.getParameter("action").equals("insertPerformance")) {

			// Append parameter of request
			String title = (String) request.getParameter("title");
			String duration = (String) request.getParameter("duration");
			String time = (String) request.getParameter("time");
			String assignedHall_ID = (String) request.getParameter("assignedHall_ID");
			String assignedHall_row = (String) request.getParameter("assignedHall_row");
			String assignedHall_seatsInRow = (String) request.getParameter("assignedHall_seatsInRow");
			String availableSeats = (String) request.getParameter("availableSeats");

			// Call application to insert offer
			new CMApplication().insertPerformance(title ,duration,time,assignedHall_ID,assignedHall_row,assignedHall_seatsInRow,availableSeats);

			// Dispatch message to template engine
			try {
				request.setAttribute("pagetitle", "Insert Performance");
				request.setAttribute("message", "New performance successful stored in the database.");
				request.getRequestDispatcher("/templates/showConfirmMake.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			// Call doGet if request is not equal to insertOffer
		} else
			doGet(request, response);

	}
}