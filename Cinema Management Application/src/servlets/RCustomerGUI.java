package servlets;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CMApplication;
import dbadapter.Performance;

/**
 * Class responsible for the GUI of the RegisteredCustomer
 * 
 * @author swe.uni-due.de
 *
 */
public class RCustomerGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet is responsible for search form and booking form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// Set navtype
		request.setAttribute("navtype", "rcustomer");

		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");

		// Case: Request booking form
		if (action.equals("selectPerformance")) {
			//NOT IMPLEMENTED
		} else {
			// Set request attributes
			request.setAttribute("pagetitle", "Browse Performances");
			// Dispatch request to template engine
			try {
				request.getRequestDispatcher("/templates/defaultWebpageRC.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Set navtype
		request.setAttribute("navtype", "registeredcustomer");
			
		if(request.getParameter("action").equals("browseAvailablePerformances")) {
				
			request.setAttribute("pagetitle", "List of Performances");
			List<Performance> availableP = null;
			
				try {
					availableP = CMApplication.getInstance().forwardRequestPerformance();
						
					// Dispatch results to template engine
					request.setAttribute("availableP", availableP);
					request.getRequestDispatcher("/templates/offersRepresentation.ftl").forward(request, response);
				} catch (Exception e1) {
					try {
						request.setAttribute("errormessage", "Database error: please contact the administator");
						request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
					} catch (Exception e) {
						request.setAttribute("errormessage", "System error: please contact the administrator");
						e.printStackTrace();
					}
					e1.printStackTrace();
					}
				}
			}
		
}