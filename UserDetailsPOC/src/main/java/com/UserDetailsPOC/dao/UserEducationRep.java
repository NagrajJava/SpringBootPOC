package com.UserDetailsPOC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserDetailsPOC.entity.UserEduEntity;

public interface UserEducationRep extends JpaRepository<UserEduEntity, Integer> {

}
