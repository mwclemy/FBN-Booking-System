package com.fbn.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.User;
import com.fbn.service.UserService;
import com.fbn.service.UserServiceImpl;

public class SignupServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phone = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		int roleId = 2;
		String message = "Successifully registered!";
		request.getSession().setAttribute("customerregistered", message);

		User user = new User(firstName, lastName, phone, email, password, address, roleId);

		UserService us = new UserServiceImpl();
	    boolean result = us.registerUser(user);

		if (result) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}

	}

}