package com.UserDetailsPOC.constants;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UserDetailsPOC.controller.UserController;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;

@Service
public abstract class ValidationCheck {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public boolean validFirstName(String firstName) {
		boolean valid = true;
		log.info("FirstName is ->{}", firstName);
		if (Objects.isNull(firstName) || !firstName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
		return valid;
	}

	public boolean validLastName(String lastName) {
		boolean valid = true;
		log.info("lastName is ->{}", lastName);
		if (Objects.isNull(lastName) || !lastName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
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
				|| !password.matches("^(?=.*[0-9]{1,1})(?=.*[a-z]{8,8})(?=.*[A-Z]{1,1})(?=\\\\S+$).{1,10}$")) {
			valid = false;
		}
		return valid;
	}

	public boolean validateUserMaster(UserMasterEntity entity) {
		boolean valid = false;
		log.info("user details ->{}", entity);
		if (entity.getUserName() != null && entity.getPassword() != null && entity.getUsersAddrs() != null
				&& isValidPassword(entity.getPassword())) {
			valid = true;
		}
		return valid;
	}

	public boolean validateUser(UserEntity entity) {
		boolean valid = false;
		if (entity.getFirstName() != null && entity.getLastName() != null && entity.getEmailId() != null
				&& entity.getDob() != null && entity.getDoj() != null && validFirstName(entity.getFirstName())
				&& validLastName(entity.getLastName())) {
			valid = true;
		}
		return valid;
	}

	/**
	 * For the Positive response
	 */

	public ResponseEntity<Object> responseBuilder(Object user) throws Exception {
		return new ResponseEntity<Object>(Constants.SUCCESS_MESSAGE, HttpStatus.OK);
	}

	/**
	 * For the Negetive response
	 * 
	 */
	public ResponseEntity<Object> responseBuilder(Exception exc) {
		return new ResponseEntity<Object>(Constants.FAIL_MESSAGE, HttpStatus.BAD_REQUEST);

	}

}
