package com.fbn.dao;

import java.util.List;

import com.fbn.model.Booking;

public interface BookingDAO {
	public boolean registerBooking(Booking booking) ;

	public void updateFlightAvailabilityAndStatus(int flightId, int numSeatsBusiness, int numSeatsEconomic, int numSeatsFirstClass);
    public List<Booking> getBookingsByUserId(int userId);
}
