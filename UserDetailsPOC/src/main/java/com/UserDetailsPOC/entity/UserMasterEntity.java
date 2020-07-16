package com.UserDetailsPOC.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="User_Master")
public class UserMasterEntity  extends BaseEntity{
	
	@Id
	@Column(name="userM_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer masterId;
	
	@NotNull
	@Column(name="userName")
	private String userName;
	

	@NotNull
	@Column(name="password")
	private String password;
	
	private Boolean isActive=true;
	
	@OneToMany(targetEntity = UserAddrsEntity.class, cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="userMsAddId")
	@Fetch(value=FetchMode.JOIN)
	//@OneToMany
	private Set<UserAddrsEntity> usersAddrs;
	
	public Integer getUserMasterId() {
		return masterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.masterId = userMasterId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<UserAddrsEntity> getUsersAddrs() {
		return usersAddrs;
	}

	public void setUsersAddrs(Set<UserAddrsEntity> usersAddrs) {
		this.usersAddrs = usersAddrs;
	}

	
	

}
