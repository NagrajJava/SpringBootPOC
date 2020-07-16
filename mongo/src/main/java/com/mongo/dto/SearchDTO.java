package com.mongo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SearchDTO {

	private String id;
	@Pattern(regexp = "^[A-Za-z0-9+.!#$%&'*+-/?^_`{ |-]+@[A-Za-z0-9.-]+$", message = "Invalid email id format.")
	@NotEmpty
	private String emailId;

	// @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$",
	// message = "Invalid Password format.")
	@NotEmpty
	private String password;

	@NotEmpty(message = "First Name must not be null or empty.")
	private String firstName;

	@NotEmpty(message = "Last Name must not be null or empty.")
	private String lastName;

	/*
	 * @Pattern(regexp = "^[A-Za-z0-9+.!#$%&'*+-/?^_`{ |-]+@[A-Za-z0-9.-]+$",
	 * message = "Invalid email id format.")
	 * 
	 * @NotEmpty private String emailId;
	 */

	@NotEmpty
	private String mobileNo;
	// @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{11,}$",
	// message = "Invalid Password format.")

	@NotEmpty
	private String pincode;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
