package com.UserDetailsPOC.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.UserDetailsPOC.comons.CustomException;
import com.UserDetailsPOC.constants.Constants;
import com.UserDetailsPOC.dto.DynamicSeachDTO;
import com.UserDetailsPOC.dto.ResponseDTO;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;
import com.UserDetailsPOC.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserService service;

	/**
	 * This API is used for Health Check
	 * 
	 * @return String
	 */
	@GetMapping("/healthCheck")
	public String healthCheck() {

		logger.info("Server is Working fine");
		return "Server is working fine";
	}

	/**
	 * This API is used for is used to save the Data of User Master
	 * 
	 * @return ResponseEntity<String> message
	 */
	@RequestMapping("/getAllusers")
	public ResponseDTO<List<UserEntity>> getAllUsers() {
		logger.info("Inside getAllUsers Method");
		List<UserEntity> list = new ArrayList<>();
		ResponseDTO<List<UserEntity>> responseDTO = new ResponseDTO<List<UserEntity>>();
		list = service.fetchAllUsers();
		if (!list.isEmpty()) {
			responseDTO.setData(list);
			responseDTO.setMessage(Constants.SUCCESS_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.OK.value());
		} else {
			responseDTO.setMessage(Constants.FAIL_GET_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return responseDTO;
	}

	/**
	 * This API is used for is used to save Data of User Master
	 * 
	 * @return ResponseEntity<String> message
	 */
	@RequestMapping(value = "/userMasterRegistration", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> saveUserMasterInfo(@RequestBody UserMasterEntity usermasterEntity,
			HttpServletResponse httpServletResponse) {
		logger.info("Inside saveUserMasterInfo..");
		ResponseDTO responseDTO = new ResponseDTO();
		int httpStatusCode;
		if (service.saveUserMaster(usermasterEntity)) {
			httpStatusCode = HttpStatus.OK.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.SUCCESS_MESSAGE);

		} else {
			httpStatusCode = HttpStatus.BAD_REQUEST.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.FAIL_MESSAGE);
		}
		responseDTO.setStatusCode(httpStatusCode);
		httpServletResponse.setStatus(httpStatusCode);

		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}

	/**
	 * This API is used for is used to updateUserDetailsById
	 * 
	 * @return ResponseDTO<String> message
	 */
	@RequestMapping(value = "/saveuserdetails", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> saveUserInfo(@RequestBody UserEntity entity,
			HttpServletResponse httpServletResponse) {
		logger.info("inside  saveUserInfo  method  ");
		ResponseDTO responseDTO = new ResponseDTO();
		int httpStatusCode;

		if (service.saveUser(entity)) {
			httpStatusCode = HttpStatus.OK.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.SUCCESS_MESSAGE);
		} else {
			httpStatusCode = HttpStatus.BAD_REQUEST.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.FAIL_MESSAGE);
		}
		responseDTO.setStatusCode(httpStatusCode);
		httpServletResponse.setStatus(httpStatusCode);

		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}

	/**
	 * This API is used to updateUserDetailsById
	 * 
	 * @return ResponseEntity<String> message
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUserDetailsById/{userId}", method = RequestMethod.PUT)
	public ResponseDTO updateUserDetailsById(@RequestBody UserEntity entity, @PathVariable Integer userId)
			throws Exception {
		int httpStatusCode;
		logger.debug("UpdateUserDetailsById Method Execution Started");
		ResponseDTO responseDTO = new ResponseDTO();
		if (service.modifyUserDetails(entity, userId)) {
			httpStatusCode = HttpStatus.OK.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.SUCCESS_UPDATE_MESSAGE);
		} else {
			httpStatusCode = HttpStatus.BAD_REQUEST.value();
			responseDTO.setStatusCode(httpStatusCode);
			responseDTO.setMessage(Constants.FAIL_MESSAGE);
		}

		return responseDTO;

	}

	/**
	 * This API is used for search users Dynamically
	 * 
	 * @return users list
	 */
	@RequestMapping(value = "/searchByNameAndEmailId", method = RequestMethod.POST)
	public ResponseDTO<List<UserEntity>> SearchUserByField(@RequestBody DynamicSeachDTO searchEntity)
			throws CustomException {
		logger.info("searchUser Method Execution Started");

		List<UserEntity> list = new ArrayList<>();

		ResponseDTO<List<UserEntity>> responseDTO = new ResponseDTO<>();
		list = service.fetchUserByDySearch(searchEntity);
		if (list.isEmpty()) {
			responseDTO.setMessage(Constants.FAIL_SEARCH_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());

		} else {
			responseDTO.setData(list);
			responseDTO.setMessage(Constants.SEARCH_SUCCESS_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.OK.value());
		}

		return responseDTO;
	}

	/**
	 * This API is used for deleteUserById
	 * 
	 * @return ResponseEntity<ResponseDTO> message
	 * @throws CustomException
	 */
	@RequestMapping(value = "/deleteUserById/{userId}", method = RequestMethod.DELETE)
	public ResponseDTO<String> deleteUserById(@PathVariable Integer userId) {
		logger.info("Inside DeleteById Method");
		ResponseDTO<String> responseDTO = new ResponseDTO<>();
		if (service.deleteUserById(userId)) {
			responseDTO.setMessage(Constants.SUCCESS_DELETE_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.OK.value());
		} else {
			responseDTO.setMessage(Constants.FAIL_DELETE_MESSAGE);
			responseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return responseDTO;
	}

}
