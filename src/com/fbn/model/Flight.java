package com.fbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	@Column(name = "flight_id")
	private int flightId;
	@Column(name = "flight_origin")
	private String flightOrigin;
	@Column(name = "flight_destination")
	private String flightDestination;
	@Column(name = "departure_date")
	private String departureDate;
	@Column(name = "arrival_or_return_date")
	private String arrivalOrReturnDate;
	@Column(name = "creation_date", nullable = true)
	private String creationDate;
	@Column(name = "flight_type")
	private String flightType;
	@Column(name = "flight_seats")
	private int flightSeats;
	@Column(name = "num_seats_business")
	private int numSeatsBusiness;
	@Column(name = "num_seats_economic")
	private int numSeatsEconomic;
	@Column(name = "num_seats_first_class")
	private int numSeatsFirstClass;
	@Column(name = "available_seats_business")
	private int availableSeatsBusiness;
	@Column(name = "available_seats_economic")
	private int availableSeatsEconomic;
	@Column(name = "available_seats_first_class")
	private int availableSeatsFirstClass;
	@Column(name = "status_id")
	private int statusId;

	public Flight() {

	}

	public Flight(String flightOrigin, String flightDestination, String departureDate, String arrivalOrReturnDate,
			String creationDate, String flightType, int flightSeats, int numSeatsBusiness, int numSeatsEconomic,
			int numSeatsFirstClass, int availableSeatsBusiness, int availableSeatsEconomic,
			int availableSeatsFirstClass, int statusId) {
		super();
		this.flightOrigin = flightOrigin;
		this.flightDestination = flightDestination;
		this.departureDate = departureDate;
		this.arrivalOrReturnDate = arrivalOrReturnDate;
		this.creationDate = creationDate;
		this.flightType = flightType;
		this.flightSeats = flightSeats;
		this.numSeatsBusiness = numSeatsBusiness;
		this.numSeatsEconomic = numSeatsEconomic;
		this.numSeatsFirstClass = numSeatsFirstClass;
		this.availableSeatsBusiness = availableSeatsBusiness;
		this.availableSeatsEconomic = availableSeatsEconomic;
		this.availableSeatsFirstClass = availableSeatsFirstClass;
		this.statusId = statusId;
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

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalOrReturnDate() {
		return arrivalOrReturnDate;
	}

	public void setArrivalOrReturnDate(String arrivalOrReturnDate) {
		this.arrivalOrReturnDate = arrivalOrReturnDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getFlightSeats() {
		return flightSeats;
	}

	public void setFlightSeats(int flightSeats) {
		this.flightSeats = flightSeats;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	

	

}