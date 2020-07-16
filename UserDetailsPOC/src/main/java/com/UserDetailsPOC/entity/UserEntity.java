package com.UserDetailsPOC.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="User_details")
public class UserEntity extends BaseEntity {

	@Column(name = "userid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
		
	@NotNull
	private String firstName;
		
	@NotNull
	private String lastName;
		
	@NotNull
	@Column(name = "emailId", unique = true)
	private String emailId;

	@NotNull
	@Column(name = "mobileNo", unique = true)
	private String mobileNo;
	
	
	@Column(name="dob")
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name="doj")
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date doj;
	
	private Boolean isActive = true;
	
	@OneToOne(targetEntity = UserMasterEntity.class,cascade = CascadeType.ALL )
	private UserMasterEntity userMasterEntity;

	
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

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
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

	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public UserMasterEntity getUserMasterEntity() { return userMasterEntity; }
	  
	  public void setUserMasterEntity(UserMasterEntity userMasterEntity) {
	  this.userMasterEntity = userMasterEntity; }
	 
	
	
	
}

