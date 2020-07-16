package com.mongo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.mongo.commons.Constants;
import com.mongo.commons.Validations;
import com.mongo.dto.SearchDTO;
import com.mongo.model.Address;
import com.mongo.model.Education;
import com.mongo.model.User;
import com.mongo.model.UserDetails;
import com.mongo.model.UserStatus;
import com.mongo.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserServiceController extends Validations {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);
	@Autowired
	private UserService userservice;

	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public UserStatus validateLogin() {
		return new UserStatus("User successfully authenticated");
	}
	/**
	 * saving user details
	 * 
	 */
	@PostMapping("/saveuser")
	public ResponseEntity<String> register(@RequestBody @Valid User user) {
		logger.info("Inside saveUser Method");
		if (!userservice.saveUser(user)) {
			return new ResponseEntity<String>(
					"Hi " + user.getFirstName() + " your Registration process successfully completed", HttpStatus.OK);
		}
		return new ResponseEntity<String>(
				"Hi " + user.getFirstName() + " your Registration process successfully completed", HttpStatus.OK);
	}
	// public ResponseEntity<Object> saveUser(@RequestBody @Valid User user) {
	/*
	 * ResponseEntity<Object> response = null;
	 * 
	 * try { response = validateUser(user) ?
	 * responseBuilderUser(userservice.saveUser(user)) : null;
	 * logger.info("response ->{}", response); if (response == null) {
	 * logger.warn("No user records found"); new
	 * HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found"); //
	 * return new ResponseEntity<Object>(Constants.FAIL_MESSAGE, //
	 * HttpStatus.BAD_REQUEST); } } catch (Exception e) { response =
	 * responseBuilder(e); } return response; }
	 */

	@PostMapping("/saveuseradress")
	public ResponseEntity<Object> saveUserAddress(@RequestBody Address useraddres) {
		logger.info("Inside saveUserAddress Method");
		if (userservice.saveUseraddress(useraddres)) {
			return new ResponseEntity<Object>(Constants.SUCCESS_MESSAGE, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(Constants.FAIL_MESSAGE, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/saveusereduaction")
	public ResponseEntity<Object> saveUserEducation(@RequestBody @Valid Education education) {
		logger.info("Inside saveUserAddress Method");
		if (userservice.saveUsereducation(education)) {
			return new ResponseEntity<Object>(Constants.SUCCESS_MESSAGE, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(Constants.FAIL_MESSAGE, HttpStatus.BAD_REQUEST);

	}

	/**
	 * saving user Details details
	 * 
	 */

	@PostMapping("/saveuserdetails")
	public ResponseEntity<Object> saveUsermaster(@RequestBody @Valid UserDetails userDetails) {
		logger.info("Inside saveUsermaster method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUserMaster(userDetails) ? responseBuildermaster(userservice.saveUserMaster(userDetails))
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
	public ResponseEntity<Object> updateUserByID(@RequestBody @Valid User user, @PathVariable String id) {
		logger.info("Inside updateuser method");
		ResponseEntity<Object> response = null;

		try {
			response = validateUser(user) ? responseBuilderUpdateuser(userservice.updateUser(user, id)) : null;
			logger.info("response -{}", response);
			if (response == null) {
				return new ResponseEntity<Object>(Constants.FAIL_MESSAGE, HttpStatus.BAD_REQUEST);
			}
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
	public ResponseEntity<Object> deleteById(@PathVariable String id) {
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
	@RequestMapping("/serachByProperty/{email}")
	public ResponseEntity<List<User>> serachByproeprty(@PathVariable String email) {
		logger.info("Inside serachByproeprty By email method  ->{}",email);
		List<User> users = userservice.searchByProperty(email);
		logger.debug("users are ->{}", users);
		if (users.isEmpty()) {
			logger.warn("No user records found");
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found");
		}
		return new ResponseEntity<>(users, HttpStatus.OK);

	}
	
	/**
	 * searchByProperty
	 * 
	 */
	@RequestMapping("/serachByPropertyId/{userID}")
	public ResponseEntity< Optional<User> > serachByproeprtyId(@PathVariable String userID) {
		logger.info("Inside serachByproeprtyByID method  ->{}",userID);
		 Optional<User>  users = userservice.searchByPropertyuserId(userID);
		logger.debug("users are ->{}", users);
		if (users == null) {
			logger.warn("No user records found");
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records found");
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
			
	}

	/**
	 * getting all users
	 * 
	 */
	@RequestMapping("/getAllUsers")
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
