package com.elham.restfulwebservice.messenger.exception;

/**
 * 
 * @author Elham
 *
 */
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
