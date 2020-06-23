package com.UserDetailsPOC.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.UserDetailsPOC.entity.UserMasterEntity;

public interface UserMasterRepository  extends CrudRepository<UserMasterEntity, Serializable>{

}
