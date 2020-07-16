package com.UserDetailsPOC.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.UserDetailsPOC.entity.UserMasterEntity;

public interface UserMasterRepository  extends JpaRepository<UserMasterEntity, Integer>{

}
