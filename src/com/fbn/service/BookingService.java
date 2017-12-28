package com.fbn.service;

import com.fbn.model.Booking;

public interface BookingService {
	public boolean registerBooking(Booking booking) ;
	public void updateFlightAvailabilityAndStatus(int flightId, int numSeatsBusiness, int numSeatsEconomic, int numSeatsFirstClass);
}
