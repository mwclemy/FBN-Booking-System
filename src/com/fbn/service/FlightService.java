package com.fbn.service;

import java.util.List;

import com.fbn.model.Flight;

public interface FlightService {
	public boolean registerFlight(Flight flight);

	public List<Flight> getListOfFlight();

	public boolean updateFlight(Flight flight);

	public Flight getFlightById(int flightId);

	public boolean deleteFlightById(int flightId);
	public boolean checkSeats(int totalFlightSeats, int numSeatsEconomic, int numSeatsBusiness, int numSeatsFirstClass);

}
