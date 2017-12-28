package com.fbn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerRequest {
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private int flightId;
	private int seats;
	private String dates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public CustomerRequest() {
	}

	public CustomerRequest(int customerId, int flightId, int seats, String dates) {
		this.customerId = customerId;
		this.flightId = flightId;
		this.seats = seats;
		this.dates = dates;
	}
}
