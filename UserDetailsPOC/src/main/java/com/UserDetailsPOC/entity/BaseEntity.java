package com.UserDetailsPOC.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
	public Date dateCreated = null;

	@Temporal(TemporalType.TIMESTAMP)
	public Date lastUpdated;

	@PrePersist
	public void prePersist() {
		this.dateCreated = new Date();
		this.lastUpdated = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.lastUpdated = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}

