package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Education;

public interface EducationRepo extends MongoRepository<Education, String>{

}
