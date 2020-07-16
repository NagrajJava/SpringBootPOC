package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Address;

public interface AddessRepo extends MongoRepository<Address, String> {

}
