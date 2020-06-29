package com.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.model.User;

public interface UserRepo extends MongoRepository<User, Integer> {

	//@Query(value ="{'firstName':0?}")
	List<User> findByFirstName(String firstName);

	@Query("{'mobileNo':0?}")
	List<User> findBymobileNo(String mobileNo);

	

}
