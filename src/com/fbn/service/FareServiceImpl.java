package com.fbn.service;

import java.util.List;

import com.fbn.dao.FareDAO;
import com.fbn.dao.FareDAOImpl;
import com.fbn.model.FareConfiguration;
import com.fbn.model.Flight;

public class FareServiceImpl implements FareService{

	FareDAO fd = new FareDAOImpl();

	@Override
	public boolean registerFareConfiguration(FareConfiguration fc) {
		return fd.registerFareConfiguration(fc);
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

	@Override
	public void updateFlightFareStatus(int flightId) {
		fd.updateFlightFareStatus(flightId);		
	}
	@Override
	public List<FareConfiguration> getListOfFare() {
		return fd.getListOfFare();
	}

	@Override
	public boolean updateFare(FareConfiguration fc) {
		return fd.updateFare(fc);
	}

	@Override
	public FareConfiguration getFareById(int fareId) {
		return fd.getFareById(fareId);
	}
}
