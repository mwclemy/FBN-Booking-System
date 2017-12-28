package com.fbn.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.Flight;
import com.fbn.service.FlightService;
import com.fbn.service.FlightServiceImpl;
import com.fbn.services.UserService;

public class UpdateFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters From manage flight page

		String flightOrigin = request.getParameter("flightOrigin");
		String flightDestination = request.getParameter("flightDestination");
		int numSeatsBusiness = Integer.parseInt(request.getParameter("business_seats"));
		int numSeatsEconomic = Integer.parseInt(request.getParameter("economic_seats"));
		int numSeatsFirstClass = Integer.parseInt(request.getParameter("first_class_seats"));
		// Update available seats, to equal new number of seats
		int availableSeatsBusiness = numSeatsBusiness;
		int availableSeatsEconomic = numSeatsEconomic;
		int availableSeatsFirstClass = numSeatsFirstClass;
		int totalFlightSeats = Integer.parseInt(request.getParameter("flight_seats"));
		String arrivalOrReturnDate = request.getParameter("arrivalon");
		String departureDate = request.getParameter("flightDeparture");
		int flightId = Integer.parseInt(request.getParameter("flightId"));

		FlightService fsi = new FlightServiceImpl();

		boolean seatsCondition = fsi.checkSeats(totalFlightSeats, numSeatsEconomic, numSeatsBusiness,
				numSeatsFirstClass);

		if (seatsCondition) {
			// Get Flight by id
			Flight flight = fsi.getFlightById(flightId);
			// Update flight attributes

			flight.setFlightOrigin(flightOrigin);
			flight.setArrivalOrReturnDate(arrivalOrReturnDate);
			flight.setFlightDestination(flightDestination);
			flight.setDepartureDate(departureDate);
			flight.setNumSeatsBusiness(numSeatsBusiness);
			flight.setNumSeatsEconomic(numSeatsEconomic);
			flight.setNumSeatsFirstClass(numSeatsFirstClass);
			flight.setFlightSeats(totalFlightSeats);
			flight.setAvailableSeatsBusiness(availableSeatsBusiness);
			flight.setAvailableSeatsEconomic(availableSeatsEconomic);
			flight.setAvailableSeatsFirstClass(availableSeatsFirstClass);

			// Update Flight
			boolean result = fsi.updateFlight(flight);
			if (result) {
				// Flight updated successfully
				response.sendRedirect("ManageFlight.jsp");
			} else {
				// Errors in updating flight
				response.sendRedirect("error.jsp");

			}
		} else {
			// Total number of seats < than class seats
			response.sendRedirect("error.jsp");
		}

	}

}
