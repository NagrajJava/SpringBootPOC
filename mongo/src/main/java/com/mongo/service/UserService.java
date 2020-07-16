package com.mongo.service;

import java.util.List;
import java.util.Optional;

import com.mongo.dto.SearchDTO;
import com.mongo.model.Address;
import com.mongo.model.Education;
import com.mongo.model.User;
import com.mongo.model.UserDetails;

public interface UserService {

	boolean saveUser(User user);

	List<User> getAllUsers();

	boolean deleteuserById(String id);

	boolean updateUser(User user, String id);

	boolean saveUserMaster(UserDetails userDetails);

	List<User> searchByProperty(String email);
	
	 Optional<User>  searchByPropertyuserId(String userId);

	boolean saveUseraddress(Address useraddres);

	boolean saveUsereducation(Education education);

}
