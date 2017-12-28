package com.fbn.service;

import java.util.List;

import com.fbn.dao.FareFlightDAO;
import com.fbn.dao.FareFlightDAOImpl;
import com.fbn.dto.FareFlightDTO;

public class FareFlightServiceImpl implements FareFlightService{

	FareFlightDAO ffd = new FareFlightDAOImpl();
	@Override
	public List<FareFlightDTO> getListOfFareFlights() {
		return ffd.getListOfFareFlights() ;
	}



}
