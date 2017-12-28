package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.Customers;
import com.fbn.model.User;
import com.fbn.service.UserService;
import com.fbn.service.UserServiceImpl;
import com.fbn.services.SignupService;


/**
 * Servlet implementation class UsersServlet
 */

public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phone = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		int roleId = Integer.parseInt(request.getParameter("role"));
		
		String message = "Successifully registered!";
		

		User user = new User(firstName, lastName, phone, email, password, address, roleId);
		try {
			UserService UserService = new UserServiceImpl();
			boolean result = UserService.registerUser(user);

			if (result) {
				request.getSession().setAttribute("userregistered", message);
				response.sendRedirect("AddUser.jsp");	
			} else {
				response.sendRedirect("error.jsp");
			}

		} finally {
			out.close();
		}
	}

}
