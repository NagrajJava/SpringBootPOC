package com.mongo.security;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<UserCredtentials, String> {
    UserCredtentials findByUsername(String username);
}

