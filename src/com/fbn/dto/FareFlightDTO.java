package com.fbn.dto;

import javax.persistence.Column;

public class FareFlightDTO {
	
	private int fareId;
	private int flightId;
	private int flight_status_id;
	private String flightOrigin;
	private String flightDestination;
	private String flightType;
	private int priceBusiness;
	private int priceEconomic;
	private int priceFirstClass;
	private int numSeatsBusiness;
	private int numSeatsEconomic;
	private int numSeatsFirstClass;
	private int totaFlightSeats;
	private int availableSeatsBusiness;
	private int availableSeatsEconomic;
	private int availableSeatsFirstClass;
	
	public int getTotaFlightSeats() {
		return totaFlightSeats;
	}

	public void setTotaFlightSeats(int totaFlightSeats) {
		this.totaFlightSeats = totaFlightSeats;
	}

	public FareFlightDTO() {
		
	}


	

	public int getFlight_status_id() {
		return flight_status_id;
	}

	public void setFlight_status_id(int flight_status_id) {
		this.flight_status_id = flight_status_id;
	}

	public FareFlightDTO(int fareId, int flightId, int flight_status_id, String flightOrigin, String flightDestination,
			String flightType, int priceBusiness, int priceEconomic, int priceFirstClass, int numSeatsBusiness,
			int numSeatsEconomic, int numSeatsFirstClass, int totaFlightSeats, int availableSeatsBusiness,
			int availableSeatsEconomic, int availableSeatsFirstClass) {
		super();
		this.fareId = fareId;
		this.flightId = flightId;
		this.flight_status_id = flight_status_id;
		this.flightOrigin = flightOrigin;
		this.flightDestination = flightDestination;
		this.flightType = flightType;
		this.priceBusiness = priceBusiness;
		this.priceEconomic = priceEconomic;
		this.priceFirstClass = priceFirstClass;
		this.numSeatsBusiness = numSeatsBusiness;
		this.numSeatsEconomic = numSeatsEconomic;
		this.numSeatsFirstClass = numSeatsFirstClass;
		this.totaFlightSeats = totaFlightSeats;
		this.availableSeatsBusiness = availableSeatsBusiness;
		this.availableSeatsEconomic = availableSeatsEconomic;
		this.availableSeatsFirstClass = availableSeatsFirstClass;
	}

	public int getAvailableSeatsBusiness() {
		return availableSeatsBusiness;
	}

	public void setAvailableSeatsBusiness(int availableSeatsBusiness) {
		this.availableSeatsBusiness = availableSeatsBusiness;
	}

	public int getAvailableSeatsEconomic() {
		return availableSeatsEconomic;
	}

	public void setAvailableSeatsEconomic(int availableSeatsEconomic) {
		this.availableSeatsEconomic = availableSeatsEconomic;
	}

	public int getAvailableSeatsFirstClass() {
		return availableSeatsFirstClass;
	}

	public void setAvailableSeatsFirstClass(int availableSeatsFirstClass) {
		this.availableSeatsFirstClass = availableSeatsFirstClass;
	}

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightOrigin() {
		return flightOrigin;
	}

	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getPriceBusiness() {
		return priceBusiness;
	}

	public void setPriceBusiness(int priceBusiness) {
		this.priceBusiness = priceBusiness;
	}

	public int getPriceEconomic() {
		return priceEconomic;
	}

	public void setPriceEconomic(int priceEconomic) {
		this.priceEconomic = priceEconomic;
	}

	public int getPriceFirstClass() {
		return priceFirstClass;
	}

	public void setPriceFirstClass(int priceFirstClass) {
		this.priceFirstClass = priceFirstClass;
	}

	public int getNumSeatsBusiness() {
		return numSeatsBusiness;
	}

	public void setNumSeatsBusiness(int numSeatsBusiness) {
		this.numSeatsBusiness = numSeatsBusiness;
	}

	public int getNumSeatsEconomic() {
		return numSeatsEconomic;
	}

	public void setNumSeatsEconomic(int numSeatsEconomic) {
		this.numSeatsEconomic = numSeatsEconomic;
	}

	public int getNumSeatsFirstClass() {
		return numSeatsFirstClass;
	}

	public void setNumSeatsFirstClass(int numSeatsFirstClass) {
		this.numSeatsFirstClass = numSeatsFirstClass;
	}
	
	

}
