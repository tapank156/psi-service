package com.scholastic.scent.exception;

//adding this in this file
public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String msg, String th){
		super(msg, new Exception(th));
	}
	public UserNotFoundException(String msg){
		super(msg);
	}
}
