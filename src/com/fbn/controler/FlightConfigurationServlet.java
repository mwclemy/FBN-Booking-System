package com.fbn.controler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.Flight;
import com.fbn.service.FlightService;
import com.fbn.service.FlightServiceImpl;
import com.fbn.util.Util;

public class FlightConfigurationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Getting form data[data from AddFlight.jsp] */
		String flightType = request.getParameter("flighttype");
		String flightOrigin = request.getParameter("origin");
		String flightDestination = request.getParameter("destination");
		String departureDate = request.getParameter("departon").replace("T", " ");
		String arrivalOrReturnDate = request.getParameter("arrivalorreturn").replace("T", " ");
		int flightSeats = Integer.parseInt(request.getParameter("seats"));
		int numSeatsBusiness = Integer.parseInt(request.getParameter("business_seats"));
		int numSeatsEconomic = Integer.parseInt(request.getParameter("economic_seats"));
		int numSeatsFirstClass = Integer.parseInt(request.getParameter("first_class_seats"));
		// For the new flight, Available seats equal Number of seats
		int availableSeatsBusiness = numSeatsBusiness;
		int availableSeatsEconomic = numSeatsEconomic;
		int availableSeatsFirstClass = numSeatsFirstClass;
		String creationDate = new Util().formatDate(new Date());

		FlightService fsi = new FlightServiceImpl();

		boolean seatsCondition = fsi.checkSeats(flightSeats, numSeatsEconomic, numSeatsBusiness, numSeatsFirstClass);
		if (seatsCondition) {
			// By default the flight status is unconfigured
			int statusId = 1;
			// Create flight object
			Flight flight = new Flight(flightOrigin, flightDestination, departureDate, arrivalOrReturnDate,
					creationDate, flightType, flightSeats, numSeatsBusiness, numSeatsEconomic, numSeatsFirstClass,
					availableSeatsBusiness, availableSeatsEconomic, availableSeatsFirstClass, statusId);
			boolean result = fsi.registerFlight(flight);
			if (result) {
				/* Setting on-success message */
				String successMessage = "Data has successiful sent to server!";
				request.getSession().setAttribute("addingFight", successMessage);
				response.sendRedirect("AddFlight.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else {
			response.sendRedirect("error.jsp");
		}

	}

}
