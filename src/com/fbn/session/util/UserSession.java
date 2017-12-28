package com.fbn.session.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;

	private UserSession() {
	}

	public HttpSession userSession() {
		HttpSession session = request.getSession();
		return session;

	}

}
