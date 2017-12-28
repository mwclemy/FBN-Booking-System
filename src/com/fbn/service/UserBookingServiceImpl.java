package com.fbn.service;

import java.util.ArrayList;
import java.util.List;

import com.fbn.dao.BookingDAO;
import com.fbn.dao.BookingDAOImpl;
import com.fbn.dao.FareDAO;
import com.fbn.dao.FareDAOImpl;
import com.fbn.dao.FlightDAO;
import com.fbn.dao.FlightDAOImpl;
import com.fbn.dto.UserBookingDTO;
import com.fbn.model.Booking;
import com.fbn.model.FareConfiguration;
import com.fbn.model.Flight;

public class UserBookingServiceImpl implements UserBookingService {

	BookingDAO bDAO = new BookingDAOImpl();
	FlightDAO fDAO = new FlightDAOImpl();
	FareDAO fareDAO = new FareDAOImpl();

	@Override
	public List<UserBookingDTO> getBookingsByUserId(int userId) {

		// Get List of bookings for the user
		List<Booking> bookings = bDAO.getBookingsByUserId(userId);
        List<UserBookingDTO> ubDTOList = new ArrayList<UserBookingDTO>();
		for (Booking booking : bookings) {
			UserBookingDTO ubDTO = new UserBookingDTO();
			// Get flight attached to it
			Flight flight = fDAO.getFlightById(booking.getFlightId());
			// Get Fare for the flight

			FareConfiguration fare = fareDAO.getFareByFlightId(flight.getFlightId());
			// Construct the User Booking DTO
			
			ubDTO.setFlightId(flight.getFlightId());
			ubDTO.setBookingId(booking.getBookingId());
			ubDTO.setUserId(booking.getUserId());
			ubDTO.setNumSeatsBusiness(booking.getNumSeatsBusiness());
			ubDTO.setNumSeatsEconomic(booking.getNumSeatsEconomic());
			ubDTO.setNumSeatsFirstClass(booking.getNumSeatsFirstClass());
			ubDTO.setPriceBusiness(fare.getPriceBusiness());
			ubDTO.setPriceEconomic(fare.getPriceEconomic());
			ubDTO.setPriceFirstClass(fare.getPriceFirstClass());
			// Calculate totalPrice
			int totalPrice = getTotalPrice(booking.getNumSeatsBusiness(), booking.getNumSeatsEconomic(), booking.getNumSeatsFirstClass(), booking.getNumSeatsBusiness(), booking.getNumSeatsEconomic(), booking.getNumSeatsFirstClass());
			ubDTO.setTotalPrice(totalPrice);
			ubDTO.setBookingDate(booking.getBookingDate());
			// Add to the list of booking
			ubDTOList.add(ubDTO);
            
		}
		return ubDTOList;
	}

	@Override
	public int getTotalPrice(int priceBusiness, int priceEconomic, int priceFirstClass, int numSeatsBusiness,
			int numSeatsEconomic, int numSeatsFirstClass) {
		
		int totalPrice = (priceBusiness * numSeatsBusiness) + (priceEconomic *numSeatsEconomic) + (priceFirstClass * numSeatsFirstClass);
		return totalPrice;
	}

}
