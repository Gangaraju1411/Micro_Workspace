package com.ashokit.exception;

public class UserNotFoundException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200564028546705444L;

	public UserNotFoundException() {

	}

	public UserNotFoundException(String msg) {
		super(msg);//super class is RuntimeException is called

	}

}