package com.UserDetailsPOC.dto;

public class DynamicSeachDTO  {
	private String firstName;
	private String lastName;
	private Integer pincode;
	private String email;
	
	public DynamicSeachDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DynamicSeachDTO(String firstName, String lastName, Integer pincode, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pincode = pincode;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
