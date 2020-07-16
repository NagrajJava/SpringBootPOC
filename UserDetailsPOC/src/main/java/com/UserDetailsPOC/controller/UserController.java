package com.UserDetailsPOC.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.UserDetailsPOC.comons.CustomException;
import com.UserDetailsPOC.comons.ValidationUtils;
import com.UserDetailsPOC.constants.Constants;
import com.UserDetailsPOC.constants.ValidationCheck;
import com.UserDetailsPOC.dto.DynamicSeachDTO;
import com.UserDetailsPOC.dto.ResponseDTO;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;
import com.UserDetailsPOC.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends ValidationCheck {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserService service;

	ValidationUtils validateUtils = new ValidationUtils();

	@GetMapping("/healthCheck")
	public String healthCheck() {

		logger.info("Server is Working fine");
		return "Server is working fine";
	}

	/**
	 * This API is used for is used to save the Data of User Master
	 * 
	 * @return ResponseEntity<Object> message
	 */

	@PostMapping("/saveUser")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserEntity user) {
		ResponseEntity<Object> response = null;

		try {
			response = validateUser(user) ? responseBuilder(service.saveUser(user)) : null;
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;
	}

	@PostMapping("/saveUserMaster")
	public ResponseEntity<Object> saveUserMaster(@Valid @RequestBody UserMasterEntity userMaster) {
		ResponseEntity<Object> response = null;

		try {
			response = validateUserMaster(userMaster) ? responseBuilder(service.saveUserMaster(userMaster)) : null;
		} catch (Exception e) {
			response = responseBuilder(e);
		}
		return response;
	}

	@RequestMapping("/getAllusers")
	public ResponseDTO<List<UserEntity>> getAllUsers() {

		logger.info("Inside getAllUsers method");
		ResponseDTO<List<UserEntity>> responseDTO = new ResponseDTO<List<UserEntity>>();
		List<UserEntity> userlist = service.fetchAllUsers();
		if (userlist == null) {
			logger.warn("No user records found");
			responseDTO.setData(userlist);
			responseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDTO.setMessage(Constants.FAIL_GET_MESSAGE);
			return responseDTO;
			// new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user records
			// found");
		}
		responseDTO.setData(userlist);
		responseDTO.setStatusCode(HttpStatus.OK.value());
		responseDTO.setMessage(Constants.SEARCH_SUCCESS_MESSAGE);
		return responseDTO;
	}

	/**
	 * This API is used for is used to save Data of User Master
	 * 
	 * @return ResponseEntity<String> message
	 */
	/*
	 * @RequestMapping(value = "/Saveusermaster", method = RequestMethod.POST)
	 * public ResponseEntity<String> saveUserMasterInfo(@Valid @RequestBody
	 * UserMasterEntity usermasterEntity) throws CustomException{
	 * logger.info("Inside saveUserMasterInfo.."); try {
	 * 
	 * if(!service.saveUserMaster(usermasterEntity)) return new
	 * ResponseEntity<>(Constants.VALIDATION_FAIL_MESSAGE, HttpStatus.BAD_REQUEST);
	 * } catch (Exception e) { throw new
	 * CustomException("User Master Not Saved!!!"); }
	 * 
	 * return new ResponseEntity<>(Constants.SUCCESS_MESSAGE, HttpStatus.OK);
	 * 
	 * }
	 */

	/**
	 * This API is used for is used to save user Details
	 * 
	 * @return ResponseEntity<String> message
	 */
	@RequestMapping(value = "/saveuserdetails", method = RequestMethod.POST)
	public ResponseEntity<String> saveUserInfo(@RequestBody UserEntity entity) {
		logger.info("inside  saveUserInfo  method  ");
		if (!service.saveUser(entity)) {
			return new ResponseEntity<>(Constants.VALIDATION_FAIL_MESSAGE, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(Constants.SUCCESS_MESSAGE, HttpStatus.OK);
	}

	/**
	 * This API is used to updateUserDetailsById
	 * 
	 * @return ResponseEntity<String> message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUserDetailsById/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserDetailsById(@RequestBody UserEntity entity, @PathVariable Integer userId) {
		logger.debug("UpdateUserDetailsById Method Execution Started");
		if (service.UpdateUserDetails(entity, userId)) {
			return new ResponseEntity<String>(Constants.FAIL_UPDATE_MESSAGE, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(Constants.SUCCESS_UPDATE_MESSAGE, HttpStatus.OK);

	}

	/**
	 * This API is used for deleteUserById
	 * 
	 * @return ResponseEntity<String> message
	 */
	@RequestMapping(value = "/deleteUserById/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		logger.info("Inside DeleteById Method");
		if (!service.deleteUserById(userId)) {
			return new ResponseEntity<String>(Constants.FAIL_DELETE_MESSAGE, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(Constants.SUCCESS_DELETE_MESSAGE, HttpStatus.OK);
	}

	/**
	 * This API is used for search users Dynamically
	 * 
	 * @return users list
	 */
	@RequestMapping(value = "/searchByNameAndEmailId", method = RequestMethod.POST)
	public ResponseEntity<List<UserEntity>> SearchUserByField(@RequestBody DynamicSeachDTO searchEntity) {
		logger.info("searchUser Method Execution Started");

		List<UserEntity> list = new ArrayList<>();

		list = service.fetchUserByDySearch(searchEntity);
		return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);

	}

}
