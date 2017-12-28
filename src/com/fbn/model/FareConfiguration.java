package com.fbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fare")
public class FareConfiguration {
	@Id
	@GeneratedValue
	@Column(name = "fare_id")
	private int fareId;
	@Column(name = "flight_id")
	private int flightId;
	@Column(name = "price_business")
	private int priceBusiness;
	@Column(name = "price_economic")
	private int priceEconomic;
	@Column(name = "price_first_class")
	private int priceFirstClass;
	@Column(name = "creation_date")
	private String creationDate;

	public FareConfiguration() {
	}

	public FareConfiguration(int flightId, int priceBusiness, int priceEconomic, int priceFirstClass, String creationDate) {
		this.flightId = flightId;
		this.priceBusiness = priceBusiness;
		this.priceEconomic = priceEconomic;
		this.priceFirstClass = priceFirstClass;
		this.creationDate = creationDate;
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
