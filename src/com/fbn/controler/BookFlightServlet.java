package com.fbn.controler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.Booking;
import com.fbn.service.BookingService;
import com.fbn.service.BookingServiceImpl;
import com.fbn.util.Util;


public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// Get Parameters
		int flightId = Integer.parseInt(request.getParameter("flight_id"));
		int userId = (int) request.getSession().getAttribute("Id");
		int numSeatsBusiness = Integer.parseInt(request.getParameter("business_seats"));
		int numSeatsEconomic = Integer.parseInt(request.getParameter("economic_seats"));
		int numSeatsFirstClass = Integer.parseInt(request.getParameter("first_class_seats"));
		String bookingDate = new Util().formatDate(new Date());
		// Construct a booking Object 
		
		Booking booking = new Booking(userId,flightId, numSeatsBusiness,numSeatsEconomic, numSeatsFirstClass,
				bookingDate);
		
		// Book the flight
		BookingService bs = new BookingServiceImpl();
		boolean result = bs.registerBooking(booking);
		if (result) {
			// change flight availability and status to booked
			bs.updateFlightAvailabilityAndStatus(flightId, numSeatsBusiness, numSeatsEconomic,
					numSeatsFirstClass);
			//Return success message
			response.sendRedirect("BookFlight.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
		
		
	}

}
