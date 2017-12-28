package com.fbn.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbn.model.FareConfiguration;
import com.fbn.service.FareService;
import com.fbn.service.FareServiceImpl;

/**
 * Servlet implementation class UpdateFareServlet
 */
public class UpdateFareServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Parameters
		int priceBusiness = Integer.parseInt(request.getParameter("business_class_UP"));
		int priceEconomic = Integer.parseInt(request.getParameter("economic_class_UP"));
		int priceFirstClass = Integer.parseInt(request.getParameter("first_class_class_UP"));
		int fareId = Integer.parseInt(request.getParameter("fare_id"));

		FareService fs = new FareServiceImpl();

		// Get fare by id
		FareConfiguration fc = fs.getFareById(fareId);

		fc.setPriceBusiness(priceBusiness);
		fc.setPriceEconomic(priceEconomic);
		fc.setPriceFirstClass(priceFirstClass);
		boolean result = fs.updateFare(fc);
			if (result) {
				// Fare successfully updated
				response.sendRedirect("UpdateFare.jsp");
			} else {
				// Some error occurred
				response.sendRedirect("error.jsp");
			}

	}

}
