package com.fbn.service;

import com.fbn.dao.BookingDAO;
import com.fbn.dao.BookingDAOImpl;
import com.fbn.dao.FlightDAO;
import com.fbn.dao.FlightDAOImpl;
import com.fbn.model.Booking;
import com.fbn.model.Flight;

public class BookingServiceImpl implements BookingService {

	BookingDAO bDAO = new BookingDAOImpl();
	FlightDAO fDAO = new FlightDAOImpl();

	@Override
	public boolean registerBooking(Booking booking) {
		return bDAO.registerBooking(booking);

	}

	@Override
	public void updateFlightAvailabilityAndStatus(int flightId, int numSeatsBusiness, int numSeatsEconomic,
			int numSeatsFirstClass) {
		// Get the flight by id
		Flight flight = fDAO.getFlightById(flightId);
		int availableSeatsBusiness = flight.getAvailableSeatsBusiness() - numSeatsBusiness;
		int availableSeatsEconomic = flight.getAvailableSeatsEconomic() - numSeatsEconomic;
		int availableSeatsFirstClass = flight.getAvailableSeatsFirstClass() - numSeatsFirstClass;

		int totalAvailableSeats = availableSeatsEconomic + availableSeatsEconomic + availableSeatsFirstClass;

		if (totalAvailableSeats == 0) {
			// change flight status to Booked
			flight.setAvailableSeatsEconomic(availableSeatsEconomic);
			flight.setAvailableSeatsBusiness(availableSeatsBusiness);
			flight.setAvailableSeatsFirstClass(availableSeatsFirstClass);
			flight.setStatusId(3);

			// Update Flight
			fDAO.updateFlight(flight);

		} else {
			// change flight attributes
			flight.setAvailableSeatsEconomic(availableSeatsEconomic);
			flight.setAvailableSeatsBusiness(availableSeatsBusiness);
			flight.setAvailableSeatsFirstClass(availableSeatsFirstClass);
			// Update Flight
			fDAO.updateFlight(flight);
		}
	}

}
