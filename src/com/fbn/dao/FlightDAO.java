package com.fbn.dao;

import java.util.List;

import com.fbn.model.Flight;

public interface FlightDAO {
	public boolean registerFlight(Flight flight);
	public List<Flight> getListOfFlight();//non configured flight
	public boolean updateFlight(Flight flight);
	public Flight getFlightById(int flightId);
	public boolean deleteFlightById(int flightId);
	
}
