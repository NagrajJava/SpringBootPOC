package com.mongo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.model.Address;
import com.mongo.model.Education;
import com.mongo.model.User;
import com.mongo.model.UserDetails;
import com.mongo.repository.AddessRepo;
import com.mongo.repository.EducationRepo;
import com.mongo.repository.UserMasterRepo;
import com.mongo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepo userRepo;

	@Autowired
	UserMasterRepo usermasterrepo;
	
	@Autowired
	AddessRepo addessRepo;
	
	@Autowired
	EducationRepo educationRepo;

	@Override
	public boolean saveUser(User user) {
		logger.info("Inside save user Method");
		if (user.getFirstName() != null) {
			//user.setCreateddate(new Date());
			//user.setUpdateddate(new Date());
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
	public boolean deleteuserById(String id) {
		logger.info("Inside delete userById Method");
		if (id != null) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user, String id) {
		logger.info("Inside Update user Method");
		Optional<User> userdb = userRepo.findById(id);
		if (userdb.isPresent()) {
			User existinguser = userdb.get();
			//existinguser.setUpdateddate(new Date());
			existinguser.setFirstName(user.getFirstName());
			existinguser.setLastName(user.getLastName());
			existinguser.setMobile(user.getMobile());
			existinguser.setAddress(user.getAddress());
			//existinguser.setIsActive(user.getIsActive());
			//existinguser.setUserDetails(user.getUserDetails());
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
	public boolean saveUserMaster(UserDetails userDetails) {
		logger.info("Inside Save userDetails MEthod");
		if (userDetails != null) {
			usermasterrepo.save(userDetails);
			return true;
		}
		return false;
	}

	@Override
	public List<User> searchByProperty(String email) {
		logger.info("Inside SearchBy Property Method");
		return userRepo.findByEmail(email);
	}
	
	@Override
	public Optional<User> searchByPropertyuserId(String userid) {
		logger.info("Inside SearchBy Property Method");
		Optional<User> user = userRepo.findById(userid);
		return user;
	}
	@Override
	public boolean saveUseraddress(Address useraddres) {
		logger.info("Inside save user Method");
			if (useraddres.getAid()!= null) {
				
				addessRepo.save(useraddres);
				return true;
			}

			return false;
		}


	@Override
	public boolean saveUsereducation(@Valid Education education) {
		logger.info("Inside save user Method");
		if (education.getEid()!= null) {
			
			educationRepo.save(education);
			return true;
		}

		return false;
	}
		
	

}
