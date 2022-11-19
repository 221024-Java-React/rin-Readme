package com.example.exceptions;

public class TicketAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TicketAlreadyExistException(){
		super("The Ticket is already registered");
		System.out.println("Enters Ticket exist exception");
	}
	
}