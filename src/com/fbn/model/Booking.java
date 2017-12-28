package com.fbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "flight_id")
	private int flightId;
	@Column(name = "num_seats_business")
	private int numSeatsBusiness;
	@Column(name = "num_seats_economic")
	private int numSeatsEconomic;
	@Column(name = "num_seats_first_class")
	private int numSeatsFirstClass;
	@Column(name = "booking_date")
	private String bookingDate;
	
	public Booking() {
	}
	public Booking(int userId, int flightId, int numSeatsBusiness, int numSeatsEconomic, int numSeatsFirstClass,
			String bookingDate) {
		this.userId = userId;
		this.flightId = flightId;
		this.numSeatsBusiness = numSeatsBusiness;
		this.numSeatsEconomic = numSeatsEconomic;
		this.numSeatsFirstClass = numSeatsFirstClass;
		this.bookingDate = bookingDate;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	

}
