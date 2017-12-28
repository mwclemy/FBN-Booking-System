package com.fbn.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.service.FlightService;
import com.fbn.service.FlightServiceImpl;

public class DeleteFlightServelet extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the flight id
		int flightId=Integer.parseInt(request.getParameter("flightId"));
		// Call Delete Flight service
		FlightService fsi = new FlightServiceImpl();
		boolean result = fsi.deleteFlightById(flightId);
		if (result) {
			// The flight successfully deleted
			response.sendRedirect("ManageFlight.jsp");
		}
		
		else {
			// Deletion error
			response.sendRedirect("error.jsp");
		}
		
		
	}


}
