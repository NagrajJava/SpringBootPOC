package com.mongo.commons;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mongo.dto.ResponseDTO;
import com.mongo.model.User;
import com.mongo.model.UserDetails;

public abstract class Validations {
	private static final Logger log = LoggerFactory.getLogger(Validations.class);

	public boolean isvalidFirstName(String firstName) {
		boolean valid = true;
		log.info("FirstName is ->{}", firstName);
		if (Objects.isNull(firstName) || !firstName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
		log.info("Valided -{}", valid);
		return valid;
	}

	public boolean isvalidLastName(String lastName) {
		boolean valid = true;
		log.info("lastName is ->{}", lastName);
		if (Objects.isNull(lastName) || !lastName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
		log.info("Valided -{}", valid);
		return valid;
	}

	public boolean isValidEmail(String email) {
		final String regex = "^[A-Za-z0-9+.!#$%&'*+-/?^_`{ |-]+@[A-Za-z0-9.-]+$";
		log.info("email is ->{}", email);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean isValidPassword(String password) {
		boolean valid = true;
		log.info("password is ->{}", password);
		if (password.length() >= 5 || Objects.isNull(password)
				|| !password.matches("^(?=.*[0-9]{1,1})(?=.*[a-z]{2,2})(?=.*[A-Z]{2,2})(?=\\S+$).{1,6}$")) {
			valid = false;
		}
		log.info("Valided -{}", valid);
		return valid;
	}

	public boolean validateUserMaster(UserDetails userDetails) {
		boolean valid = false;
		log.info("usermaster details ->{}", userDetails);
		if (userDetails.getUserName() != null && userDetails.getPassword() != null && userDetails.getAddress() != null
				&& isvalidFirstName(userDetails.getUserName())) {
			valid = true;
		}
		return valid;
	}

	public boolean validateUser(User user) {
		boolean valid = false;
		log.info("user details ->{}", user);
		if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null
				&& isvalidFirstName(user.getFirstName()) && isvalidLastName(user.getLastName())) {
			valid = true;
		}
		return valid;
	}
	
	public boolean validateUserId(String id) {
		boolean valid = true;
		log.info("userId ->{}", id);
		if (id.isEmpty()) {
			valid = false;
		}
		return valid;
	}
	/*
	 * public boolean validatesearchDTO(SearchDTO searchDTO) { boolean valid =
	 * false; if (searchDTO.getFirstName() != null && searchDTO.getLastName() !=
	 * null && searchDTO.getEmailId() != null) { valid = true; } return valid; }
	 */

	/**
	 * For the Positive response
	 */

	public ResponseEntity<Object> responseBuilderUser(Object user) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setData(user);
		responseDTO.setMsg(Constants.SUCCESS_MESSAGE);
		responseDTO.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<Object>(responseDTO, HttpStatus.OK);
	}

	public ResponseEntity<Object> responseBuildermaster(Object userDetails) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMsg(Constants.SUCCESS_MESSAGE);
		responseDTO.setData(userDetails);
		responseDTO.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<Object>(responseDTO, HttpStatus.OK);
	}

	public ResponseEntity<Object> responseBuildersearchByProperty(Object searchDTO) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMsg(Constants.SEARCH_SUCCESS_MESSAGE);
		responseDTO.setData(searchDTO);
		responseDTO.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<Object>(responseDTO, HttpStatus.OK);
	}

	public ResponseEntity<Object> responseBuilderUpdateuser(Object user) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMsg(Constants.SUCCESS_UPDATE_MESSAGE);
		responseDTO.setData(user);
		responseDTO.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<Object>(responseDTO, HttpStatus.OK);
	}
	public ResponseEntity<Object> responseBuilderdeleteUser(Object id) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setData(id);
		responseDTO.setMsg(Constants.SUCCESS_DELETE_MESSAGE);
		responseDTO.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<Object>(responseDTO, HttpStatus.OK);
	}

	/**
	 * For the Negetive response
	 * 
	 */
	public ResponseEntity<Object> responseBuilder(Exception exc) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMsg(Constants.FAIL_MESSAGE);
		responseDTO.setData(Boolean.FALSE);
		responseDTO.setStatuscode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<Object>(responseDTO, HttpStatus.BAD_REQUEST);

	}

}
