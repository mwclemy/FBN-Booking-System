package com.fbn.dao;

import java.util.ArrayList;
import java.util.List;

import com.fbn.dto.FareFlightDTO;
import com.fbn.model.FareConfiguration;
import com.fbn.model.Flight;

public class FareFlightDAOImpl implements FareFlightDAO {

	@Override
	public List<FareFlightDTO> getListOfFareFlights() {

		List<FareFlightDTO> listDTO = new ArrayList<>();
		Flight f = new Flight();
		FareDAO fareDAO = new FareDAOImpl();
		FlightDAO flightDAO = new FlightDAOImpl();
		List<FareConfiguration> fcs = fareDAO.getListOfFare();
		// Get the list of all flights
		for (FareConfiguration fc : fcs) {
			
			f = flightDAO.getFlightById(fc.getFlightId());
			if (f.getStatusId() == 3) {
				continue;
			}
			// Construct a list FareFlightDTO objects
			FareFlightDTO ffDTO = new FareFlightDTO();
			// Information related to fare
			ffDTO.setFareId(fc.getFareId());
			ffDTO.setPriceBusiness(fc.getPriceBusiness());
			ffDTO.setPriceEconomic(fc.getPriceEconomic());
			ffDTO.setPriceFirstClass(fc.getPriceFirstClass());
			// Information related to a flight
			ffDTO.setFlightId(f.getFlightId());
			ffDTO.setFlightDestination(f.getFlightDestination());
			ffDTO.setFlightOrigin(f.getFlightOrigin());
			ffDTO.setFlightType(f.getFlightType());
			ffDTO.setTotaFlightSeats(f.getFlightSeats());
			ffDTO.setNumSeatsEconomic(f.getNumSeatsEconomic());
			ffDTO.setNumSeatsBusiness(f.getNumSeatsBusiness());
			ffDTO.setNumSeatsFirstClass(f.getNumSeatsFirstClass());
			ffDTO.setAvailableSeatsBusiness(f.getAvailableSeatsBusiness());
			ffDTO.setAvailableSeatsEconomic(f.getAvailableSeatsEconomic());
			ffDTO.setAvailableSeatsFirstClass(f.getAvailableSeatsFirstClass());

			listDTO.add(ffDTO);
		}
		return listDTO;
	}

}
