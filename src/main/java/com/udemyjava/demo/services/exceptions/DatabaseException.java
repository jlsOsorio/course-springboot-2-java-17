package com.udemyjava.demo.services.exceptions;

public class DatabaseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	//400 error - integridade
	public DatabaseException(String msg) {
		super(msg);
	}
}
