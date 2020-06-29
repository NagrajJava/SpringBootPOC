package com.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.mongo.commons.Validations;
import com.mongo.dto.SearchDTO;
import com.mongo.model.User;
import com.mongo.model.UserMaster;
import com.mongo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserServiceController extends Validations {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);
	@Autowired
	private UserService userservice;

	/**
	 * saving user details
	 * 
	 */
	@PostMapping("/saveuserdetails")
	public ResponseEntity<Object> saveUser(@RequestBody @Valid User user) {
		logger.info("Inside saveUser Method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUser(user) ? responseBuilderUser(userservice.saveUser(user)) : null;
			logger.info("respose ->{}", response);
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;
	}

	/**
	 * saving user master details
	 * 
	 */

	@PostMapping("/saveusermasterdetails")
	public ResponseEntity<Object> saveUsermaster(@RequestBody @Valid UserMaster usermaster) {
		logger.info("Inside saveUsermaster method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUserMaster(usermaster) ? responseBuildermaster(userservice.saveUserMaster(usermaster))
					: null;
			logger.info("response ->{}", response);
			if (response == null) {
				logger.warn("No user records found");
				new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found");
				// return new ResponseEntity<Object>(Constants.FAIL_MESSAGE,
				// HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;

	}

	/**
	 * updating user by Id
	 * 
	 */

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Object> updateUserByID(@RequestBody @Valid User user, @PathVariable Integer id) {
		logger.info("Inside saveUsermaster method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUser(user) ? responseBuilderUpdateuser(userservice.updateUser(user, id)) : null;
			logger.info("response -{}", response);
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;
	}

	/**
	 * deleting user by Id
	 * 
	 */
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		logger.info("Inside deleteById method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUserId(id) ? responseBuilderdeleteUser(userservice.deleteuserById(id)) : null;
			logger.info("response ->{}", response);
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;
	}

	/**
	 * searchByProperty
	 * 
	 */
	@RequestMapping("/serachByProperty")
	public ResponseEntity<List<User>> serachByproeprty(@RequestBody @Valid SearchDTO searchDTO) {
		logger.info("Inside serachByproeprty method");
		List<User> users = userservice.searchByProperty(searchDTO);
		logger.debug("users are ->{}", users);
		if (users.isEmpty()) {
			logger.warn("No user records found");
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found");
		}
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	/**
	 * getting all users
	 * 
	 */
	@RequestMapping("/getUsers")
	public ResponseEntity<List<User>> getAllusers() {
		logger.info("Inside serachByproeprty method");
		List<User> users = userservice.getAllUsers();
		logger.debug("users are ->{}", users);
		if (users.isEmpty()) {
			logger.warn("No user records found");
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found");
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}
