package com.fbn.service;

import java.util.List;

import com.fbn.model.FareConfiguration;

public interface FareService {
	public boolean registerFareConfiguration(FareConfiguration fc) ;
	public boolean checkSeats(int totalFlightSeats, int numSeatsEconomic, int numSeatsBusiness, int numSeatsFirstClass);
	public void updateFlightFareStatus(int flightId);
	public List<FareConfiguration> getListOfFare();
	public boolean updateFare(FareConfiguration fc);
	public FareConfiguration getFareById(int fareId);
}
