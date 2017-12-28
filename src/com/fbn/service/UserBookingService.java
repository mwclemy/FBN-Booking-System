package com.fbn.service;

import java.util.List;

import com.fbn.dto.UserBookingDTO;

public interface UserBookingService {
	public List<UserBookingDTO> getBookingsByUserId(int userId);
	public int getTotalPrice(int priceBusiness, int priceEconomic, int priceFirstClass, int numSeatsBusiness, int numSeatsEconomic, int numSeatsFirstClass);
}
