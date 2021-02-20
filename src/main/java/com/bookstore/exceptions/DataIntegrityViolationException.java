package com.bookstore.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6288002770985095582L;

	public DataIntegrityViolationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataIntegrityViolationException(String arg0) {
		super(arg0);
	}

}
