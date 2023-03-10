package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CMApplication;
import dbadapter.CustomerAccount;

public class URCustomerGUI extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// Set navtype
		request.setAttribute("navtype", "urcaccount");
		request.setAttribute("pagetitle", "RegisterAccount");
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageURC.ftl").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Contains handling of requestRegister call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("navtype", "urcaccount");
		
		// Check wether the call is requestRegister or not
		if (request.getParameter("action").equals("requestRegister")) {
	
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			CustomerAccount ca = new CMApplication().forwardRequestRegister(email, password);
			
			if(ca != null) {
				try {
					request.setAttribute("pagetitle", "RegisterAccount");
					request.setAttribute("message", "New Account successfuly stored in the database.");
					request.getRequestDispatcher("/templates/showConfirmMake.ftl").forward(request, response);

				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					request.setAttribute("pagetitle", "Cannot Register Account");
					request.setAttribute("errormessage", "Account already exists in the database.");
					request.getRequestDispatcher("/templates/error.ftl").forward(request, response);

				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
			
		} else {
			doGet(request, response);
			
		}
	}
}
