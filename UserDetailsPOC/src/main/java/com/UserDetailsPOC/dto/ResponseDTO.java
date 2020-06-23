package com.UserDetailsPOC.dto;

public class ResponseDTO<T> {

	private Integer statusCode;
	private T data;
    private String message;
    
    
    
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
