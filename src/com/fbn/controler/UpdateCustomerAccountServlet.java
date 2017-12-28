package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbn.model.Customers;
import com.fbn.services.LoginService;
import com.fbn.services.SignupService;
import com.fbn.services.UserService;

/**
 * Servlet implementation class UpdateCustomerAccountServlet
 */

public class UpdateCustomerAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String tel = request.getParameter("tel");
		String oldemail = request.getParameter("oldemail");
		String oldpassword = request.getParameter("oldpassword");
		String newemail = request.getParameter("newemail");
		String newpassword = request.getParameter("newpassword");
		String message = "Successifully updated!";
		request.getSession().setAttribute("updated", message);

		SignupService updateCustomer = new SignupService();
		
		/* To get user Id */
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		int c = updateCustomer.getCustomerByEmailAndPassword(oldemail, oldpassword);
		
		/* To update user Id */
		boolean result = updateCustomer.updateCustomerAccount(userId, tel, newemail, newpassword);

		if (result) {
			response.sendRedirect("cust-updateAccount.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
