package com.UserDetailsPOC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserDetailsPOC.entity.UserContract;

public interface UserContractRepo  extends JpaRepository<UserContract, Integer>{

}
