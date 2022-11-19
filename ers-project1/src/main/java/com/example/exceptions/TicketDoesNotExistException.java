package com.example.exceptions;

public class TicketDoesNotExistException extends RuntimeException{
	public TicketDoesNotExistException() {
		super("Ticket you search for does not exist");
		System.out.println("Ticket does not exist");
	}
}

