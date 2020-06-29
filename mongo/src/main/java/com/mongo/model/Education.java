package com.mongo.model;

import javax.validation.constraints.NotNull;

public class Education {

	@NotNull
	private String school;

	@NotNull
	private String college;

	@NotNull
	private String branch;

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
