package com.UserDetailsPOC.comons;

import java.util.Objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	public boolean validFirstName(String firstName) {
		boolean valid = true;
		System.out.println("FirstName is :: " + firstName);
		if (Objects.isNull(firstName) || !firstName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
		System.out.println("valid :: " + valid);
		return valid;
	}

	public boolean validLastName(String lastName) {
		boolean valid = true;
		System.out.println("LastName is :: " + lastName);
		if (Objects.isNull(lastName) || !lastName.matches("^[A-Za-z]{1,256}$")) {
			valid = false;
		}
		System.out.println("valid :: " + valid);
		return valid;
	}

	public boolean isValidEmail(String email) {
		final String regex = "^[A-Za-z0-9+.!#$%&'*+-/?^_`{ |-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean isValidPassword(String password) {
		boolean valid = true;
		if (password.length() >= 5 || Objects.isNull(password)
				|| !password.matches("^(?=.*[0-9]{1,1})(?=.*[a-z]{8,8})(?=.*[A-Z]{1,1})(?=\\\\S+$).{1,10}$")) {
			valid = false;
		}
		return valid;
	}

	public boolean validMobileNo(String mobileNo) {
		boolean valid = true;
		System.out.println("MobileNo is :: " + mobileNo);
		if (Objects.isNull(mobileNo) || !mobileNo.matches("^[0-9]{10}$")) {
			valid = false;
		}
		System.out.println("valid :: " + valid);
		return valid;
	}

	/*
	 * public boolean validNewPasswordAndConfirmPassword(String newPassword, String
	 * confirmPassword) { boolean valid = true;
	 * System.out.println("New Password is :: " + newPassword);
	 * System.out.println("Confirm Password is :: " + confirmPassword);
	 * if(Objects.isNull(newPassword) || Objects.isNull(confirmPassword) ||
	 * !newPassword.equals(confirmPassword)) { valid = false; }
	 * System.out.println("valid :: " + valid); return valid; }
	 */

	/*
	 * public boolean isValidPassword(String password) { final String regex =
	 * "^(?=.*[0-9]{1,1})(?=.*[a-z]{8,8})(?=.*[A-Z]{1,1})(?=\\S+$).{1,10}$"; Pattern
	 * pattern = Pattern.compile(regex); Matcher matcher =
	 * pattern.matcher(password); return matcher.matches(); }
	 */

}
