package com.UserDetailsPOC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserDetailsPOC.entity.UserAddrsEntity;

public interface UserAddressRepository extends JpaRepository<UserAddrsEntity, Integer>{

}
