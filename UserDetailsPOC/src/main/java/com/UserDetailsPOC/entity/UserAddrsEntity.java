package com.UserDetailsPOC.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Address")
public class UserAddrsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userAddrsId;
	
	
	@NotNull
	private String houseNo;
	
	
	@NotNull
	private String StreetName;
	
	
	@NotNull
	private String cityName;
	
	@NotNull
	private Integer pinCode;
	
	public Integer getUserAddrsId() {
		return userAddrsId;
	}

	public void setUserAddrsId(Integer userAddrsId) {
		this.userAddrsId = userAddrsId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
}
