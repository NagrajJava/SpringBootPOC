package com.mongo.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("eduction")
public class Education {

	@Id
	private String eid;
	@NotNull
	private String school;

	@NotNull
	private String college;

	@NotNull
	private String branch;

	
	
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Education(String eid, @NotNull String school, @NotNull String college, @NotNull String branch) {
		super();
		this.eid = eid;
		this.school = school;
		this.college = college;
		this.branch = branch;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	

	

}
