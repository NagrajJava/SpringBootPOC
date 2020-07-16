package com.UserDetailsPOC.comons;

public class CustomException extends Exception {

	private String str;

	public CustomException(String str) {
		super();
		this.str = str;
	}

}