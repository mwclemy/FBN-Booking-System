package com.fbn.dto;

public class UserBookingDTO {
	
	private int bookingId;
	private int flightId;
	private int userId;
	private int flight_status_id;
	private int numSeatsBusiness;
	private int numSeatsEconomic;
	private int numSeatsFirstClass;
	private int priceBusiness;
	private int priceEconomic;
	private int priceFirstClass;
	private int totalPrice;
	private String bookingDate;
	public UserBookingDTO() {
		
	}
	
	public UserBookingDTO(int bookingId, int flightId, int userId, int flight_status_id, int numSeatsBusiness,
			int numSeatsEconomic, int numSeatsFirstClass, int priceBusiness, int priceEconomic, int priceFirstClass,
			int totalPrice, String bookingDate) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.userId = userId;
		this.flight_status_id = flight_status_id;
		this.numSeatsBusiness = numSeatsBusiness;
		this.numSeatsEconomic = numSeatsEconomic;
		this.numSeatsFirstClass = numSeatsFirstClass;
		this.priceBusiness = priceBusiness;
		this.priceEconomic = priceEconomic;
		this.priceFirstClass = priceFirstClass;
		this.totalPrice = totalPrice;
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlight_status_id() {
		return flight_status_id;
	}
	public void setFlight_status_id(int flight_status_id) {
		this.flight_status_id = flight_status_id;
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
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
