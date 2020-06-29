package com.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Userdetails")
@TypeAlias("user")
public class User {

	@Id
	private Integer userid;
    @Field("firstName")
	private String firstName;
    @Field("lastName")
	private String lastName;
    @Field("emailId")
	private String emailId;
    @Field("mobileNo")
	private String mobileNo;

	private Boolean isActive = true;

	private UserMaster usermaster;

	public User(Integer userid, String firstName, String lastName, String emailId, String mobileNo, Boolean isActive,
			UserMaster usermaster) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.isActive = isActive;
		this.usermaster = usermaster;
	}

	public UserMaster getUsermaster() {
		return usermaster;
	}

	public void setUsermaster(UserMaster usermaster) {
		this.usermaster = usermaster;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
