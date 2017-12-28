package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.services.UserService;

/**
 * Servlet implementation class UpdateUserAccountServlet
 */

public class UpdateUserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int userId = 0;

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
		String message = "Successiful updated!";
		request.getSession().setAttribute("updated", message);

		UserService updateUser = new UserService();
		
		/* To get user Id */
		int c = updateUser.getUserByEmailAndPassword(oldemail, oldpassword);
		
		
		/* To update user Id */
		boolean result = updateUser.updateUserAccount(c, tel, newemail, newpassword);

		if (result) {
			response.sendRedirect("user-updateAccount.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
