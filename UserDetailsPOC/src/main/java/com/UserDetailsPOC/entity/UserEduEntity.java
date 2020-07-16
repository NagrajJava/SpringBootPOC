package com.UserDetailsPOC.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="Education")
public class UserEduEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EduId;
	
	
	@NotNull
	private String schoolName;
	
		
	@NotNull
	private String userClgName;
	
	@NotNull
	private String userBranchName;
	
	@NotNull
	private String UserClgCityName;

	public Integer getEduId() {
		return EduId;
	}

	public void setEduId(Integer eduId) {
		EduId = eduId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getUserClgName() {
		return userClgName;
	}

	public void setUserClgName(String userClgName) {
		this.userClgName = userClgName;
	}

	public String getUserBranchName() {
		return userBranchName;
	}

	public void setUserBranchName(String userBranchName) {
		this.userBranchName = userBranchName;
	}

	public String getUserClgCityName() {
		return UserClgCityName;
	}

	public void setUserClgCityName(String userClgCityName) {
		UserClgCityName = userClgCityName;
	}
	

	

}
