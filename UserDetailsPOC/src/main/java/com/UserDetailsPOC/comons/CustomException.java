package com.UserDetailsPOC.comons;

import com.UserDetailsPOC.constants.Constants;

public class CustomException extends Exception {

	private static String message = Constants.FAIL_SEARCH_MESSAGE;

	public CustomException() {
		super(message);
	}

}