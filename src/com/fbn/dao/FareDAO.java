package com.fbn.dao;

import java.util.List;

import com.fbn.model.FareConfiguration;

public interface FareDAO {
	public boolean registerFareConfiguration(FareConfiguration fcs) ;
	public void updateFlightFareStatus(int flightId);
	public List<FareConfiguration> getListOfFare();
	public boolean updateFare(FareConfiguration fc);
	public FareConfiguration getFareById(int fareId);
	public FareConfiguration getFareByFlightId(int flightId);
}
