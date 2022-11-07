package com.example.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException {
	public EmployeeDoesNotExistException() {
		super("Employee you search for does not exist.");
	}
}
