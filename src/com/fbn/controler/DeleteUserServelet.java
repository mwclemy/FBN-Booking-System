package com.fbn.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.service.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserServelet
 */
public class DeleteUserServelet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the user id
				int userId=Integer.parseInt(request.getParameter("userId"));
				System.out.println("--------------------"+userId);
				// Call Delete user service
				UserServiceImpl usi = new UserServiceImpl();
				boolean result = usi.deleteUserById(userId);
				if (result) {
					// on user successfully deleted
					response.sendRedirect("ManageUser.jsp");
				}
				
				else {
					// on deletion error
					response.sendRedirect("error.jsp");
				}
				
	}

}
