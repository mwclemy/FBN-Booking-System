package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbn.model.CustomerRequest;
import com.fbn.model.Flight;
import com.fbn.services.CustomerRequestService;
import com.fbn.services.FlightService;

/**
 * Servlet implementation class SaveCustomerRequest
 */
public class SaveCustomerRequest extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		int customerId = Integer.parseInt(session.getAttribute("Id").toString());
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		int seats = Integer.parseInt(request.getParameter("seats"));
		String dates = new Date().toString();
		String message = "Successiful added!";

		request.getSession().setAttribute("flight", message);
		CustomerRequest cr = new CustomerRequest(customerId, flightId, seats, dates);
		

		try {
			CustomerRequestService crService = new CustomerRequestService();
			crService.updateFlight(flightId,seats);

			boolean result = crService.registerCustomerRequest(cr);

			if (result) {
				response.sendRedirect("cust-requestflight.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}

		} finally {
			out.close();
		}
	}
}
