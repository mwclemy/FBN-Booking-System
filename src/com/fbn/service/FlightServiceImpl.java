package com.fbn.service;

import java.util.List;

import com.fbn.dao.FlightDAO;
import com.fbn.dao.FlightDAOImpl;
import com.fbn.model.Flight;

public class FlightServiceImpl implements FlightService {

	private FlightDAO flightDAO = new FlightDAOImpl() ;

	@Override
	public boolean registerFlight(Flight flight) {
		return flightDAO.registerFlight(flight);

	}

	@Override
	public List<Flight> getListOfFlight() {
		return flightDAO.getListOfFlight();
	}

	@Override
	public boolean updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightDAO.updateFlight(flight);
	}

	@Override
	public Flight getFlightById(int flightId) {
		// TODO Auto-generated method stub
		return flightDAO.getFlightById(flightId);
	}

	@Override
	public boolean deleteFlightById(int flightId) {
		
		return flightDAO.deleteFlightById(flightId);
	}

	@Override
	public boolean checkSeats(int totalFlightSeats, int numSeatsEconomic, int numSeatsBusiness,
			int numSeatsFirstClass) {
		int seatsSum = numSeatsBusiness+numSeatsEconomic+numSeatsFirstClass;
		if (totalFlightSeats >= seatsSum)
		return true;
		else
		return false;
	}





}
