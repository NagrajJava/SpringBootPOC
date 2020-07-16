package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.UserDetails;

public interface UserMasterRepo extends MongoRepository<UserDetails, String> {

	
}