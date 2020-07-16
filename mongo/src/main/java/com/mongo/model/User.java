package com.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Users")
@TypeAlias("user")
public class User {

	@Id
	@JsonProperty("userid")
	private String userid;

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("mobile")
	private String mobile;

	//@DBRef
	private Address address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userid, String firstName, String lastName, String email, String mobile, Address address) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * private Date createddate;
	 * 
	 * private Date updateddate;
	 * 
	 * private Boolean isActive = true;
	 * 
	 * @DBRef private UserDetails userDetails;
	 * 
	 * 
	 * public User() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * public User(String userid, String firstName, String lastName, String emailId,
	 * String mobileNo, Boolean isActive, UserDetails userDetails) { super();
	 * this.userid = userid; this.firstName = firstName; this.lastName = lastName;
	 * this.emailId = emailId; this.mobileNo = mobileNo; this.isActive = isActive;
	 * this.userDetails = userDetails; }
	 * 
	 * public String getUserid() { return userid; }
	 * 
	 * public void setUserid(String userid) { this.userid = userid; }
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * public String getEmailId() { return emailId; }
	 * 
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 * 
	 * public String getMobileNo() { return mobileNo; }
	 * 
	 * public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
	 * 
	 * public Boolean getIsActive() { return isActive; }
	 * 
	 * public void setIsActive(Boolean isActive) { this.isActive = isActive; }
	 * 
	 * public Date getCreateddate() { return createddate; }
	 * 
	 * public void setCreateddate(Date createddate) { this.createddate =
	 * createddate; }
	 * 
	 * public Date getUpdateddate() { return updateddate; }
	 * 
	 * public void setUpdateddate(Date updateddate) { this.updateddate =
	 * updateddate; }
	 * 
	 * public UserDetails getUserDetails() { return userDetails; }
	 * 
	 * public void setUserDetails(UserDetails userDetails) { this.userDetails =
	 * userDetails; }
	 */
}
