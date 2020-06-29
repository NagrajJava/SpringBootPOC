package com.mongo.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.UserMaster;

public interface UserMasterRepo extends MongoRepository<UserMaster, Integer> {

	
}