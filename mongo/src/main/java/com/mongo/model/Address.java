package com.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("Address")
public class Address {

	@Id
	@JsonProperty("aid")
	private String aid;
	@JsonProperty("houseNo")
	private String houseNo;
	@JsonProperty("streetName")
	private String streetName;
	@JsonProperty("cityName")
	private String cityName;
	@JsonProperty("pinCode")
	private String pinCode;
   
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String aid, String houseNo, String streetName, String cityName, String pinCode) {
		super();
		this.aid = aid;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.cityName = cityName;
		this.pinCode = pinCode;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
