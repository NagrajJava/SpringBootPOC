package com.mongo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.dto.SearchDTO;
import com.mongo.model.User;
import com.mongo.model.UserMaster;
import com.mongo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepo userRepo;

	@Autowired
	UserMasterRepo usermasterrepo;

	@Override
	public boolean saveUser(User user) {
		logger.info("Inside save user Method");
		if (user.getFirstName() != null) {
			userRepo.save(user);
			return true;
		}

		return false;
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Inside Get All Users Method");
		return userRepo.findAll();
	}

	@Override
	public boolean deleteuserById(Integer id) {
		logger.info("Inside delete userById Method");
		if (id != null) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user, int id) {
		logger.info("Inside Update user Method");
		Optional<User> userdb = userRepo.findById(id);
		if (userdb.isPresent()) {
			User existinguser = userdb.get();
			existinguser.setFirstName(user.getFirstName());
			existinguser.setLastName(user.getLastName());
			existinguser.setIsActive(user.getIsActive());
			existinguser.setUsermaster(user.getUsermaster());
			userRepo.save(existinguser);
			return true;
		}
		return false;
		/*
		 * userdb.ifPresent(existinguser -> {
		 * existinguser.setFirstName(user.getFirstName());
		 * existinguser.setMobileNo(user.getMobileNo()); // operate on existingCustomer
		 * });
		 */

	}

	@Override
	public boolean saveUserMaster(UserMaster usermaster) {
		logger.info("Inside Save User Master MEthod");
		if (usermaster != null) {
			usermasterrepo.save(usermaster);
			return true;
		}
		return false;
	}

	@Override
	public List<User> searchByProperty(SearchDTO searchDTO) {
		logger.info("Inside SearchBy Property Method");
		return userRepo.findByFirstName(searchDTO.getFirstName());
	}

}
