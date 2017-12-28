package com.fbn.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.FareConfiguration;
import com.fbn.service.FareService;
import com.fbn.service.FareServiceImpl;
import com.fbn.util.Util;

/**
 * Servlet implementation class FareConfig
 */
public class FareConfigurationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int priceBusiness = Integer.parseInt(request.getParameter("business_class_UP"));
		int priceEconomic = Integer.parseInt(request.getParameter("economic_class_UP"));
		int priceFirstClass = Integer.parseInt(request.getParameter("first_class_class_UP"));
		int flightId = Integer.parseInt(request.getParameter("flightId"));

		String creationDate = new Util().formatDate(new Date());

		String fareConfig = "";
		

		/* Saving process */
		FareConfiguration fc = new FareConfiguration(flightId, priceBusiness, priceEconomic, priceFirstClass,
				creationDate);
        FareService fcs = new FareServiceImpl();
			boolean result = fcs.registerFareConfiguration(fc);
			
			if (result) {
				fcs.updateFlightFareStatus(flightId);
				fareConfig = "Fare successiful configured!";
				request.getSession().setAttribute("fareConfig", fareConfig);
				response.sendRedirect("FareConfiguration.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
	}

}
