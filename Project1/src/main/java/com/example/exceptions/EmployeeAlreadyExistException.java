package com.example.exceptions;

public class EmployeeAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistException(){
		super("The person is already registered");
		System.out.println("Enters employee exist exception");
	}
	
}