package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.Flight;
import com.fbn.model.User;
import com.fbn.service.UserServiceImpl;
import com.fbn.services.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleName;
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		int roleId = Integer.parseInt(request.getParameter("role"));
		int userId = Integer.parseInt(request.getParameter("userid"));

		String message = "Successiful updated!";
		request.getSession().setAttribute("updated", message);
		UserServiceImpl usi = new UserServiceImpl();
		/* To get flight by Id */
		User user = usi.getUserById(userId);
		// Update flight attributes

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setRoleId(roleId);

		/* To update user */
		boolean result = usi.updateUser(user);

		if (result) {
			if (roleId == 1) {
				roleName = "Admin";
			} else if (roleId == 2) {
				roleName = "Customer";
			} else {
				roleName = "Travel Agent";
			}
			response.sendRedirect(
					"EmailChanges.jsp?roleName="+roleName+"&email="+email+"&firstName="+firstName);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
