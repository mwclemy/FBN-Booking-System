package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbn.model.Customers;
import com.fbn.model.User;
import com.fbn.service.LoginService;
import com.fbn.service.LoginServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id;
		int roleId;
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginService loginService = new LoginServiceImpl();
		boolean userResult = loginService.authenticateUser(email, password);
		User user = loginService.getUserByEmailAndPassword(email, password);
		if (userResult) {
			id = user.getId();
			roleId=user.getRoleId();
			request.getSession().setAttribute("user", user.getFirstName() + " " + user.getLastName());
			session.setAttribute("Id", id);
			session.setAttribute("roleId", roleId);
			if (roleId == 1) {
				// redirect to the Admin page
			response.sendRedirect("admin-dashboard.jsp");
			}
			else if (roleId == 2) {
				response.sendRedirect("CustomerDashboard.jsp");
			}
			else {
				response.sendRedirect("agent-dashboard.jsp");
			}

		}
		
		else {
			response.sendRedirect("index.jsp");
		}


	}

}
