package com.mongo.service;

import java.util.List;

import com.mongo.dto.SearchDTO;
import com.mongo.model.User;
import com.mongo.model.UserMaster;

public interface UserService {

	boolean saveUser(User user);

	List<User> getAllUsers();

	boolean deleteuserById(Integer id);

	boolean updateUser(User user, int id);

	boolean saveUserMaster(UserMaster usermaster);

	List<User> searchByProperty(SearchDTO searchDTO);

}
