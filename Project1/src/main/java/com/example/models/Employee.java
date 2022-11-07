package com.example.models;

import java.util.ArrayList;

public class Employee{
	private int id;
	private EmployeeType type;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	protected Ticket reimbursementTicket = new Ticket();
	protected ArrayList<Ticket> reimbursementTicketsList = new ArrayList <Ticket>();
	
	public Employee() {
		super();
	}
	
	public Employee(int id, EmployeeType type, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Employee(EmployeeType type, String firstName, String lastName, String email, String password) {
		super();
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public void submitReimbursementTicket(double amount, String description) {
		reimbursementTicket.setAmount(amount);
		reimbursementTicket.setDescription(description);
		
		try {
				if(reimbursementTicket.equals(null))
					throw new NullPointerException();
				else
					reimbursementTicketsList.add(reimbursementTicket);
		}catch (NullPointerException e) {
			System.out.println("List is empty");
		}
	}
	
	public void processReimbursementTicket(String approval) {
		switch(approval) {
		case "approved":
			System.out.println("Ticket " + reimbursementTicket.getStatus());
			break;
		case "denied":
			System.out.println("Ticket " + reimbursementTicket.getStatus());
			break;
		default:
			
			break;
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "Employee [id=" + id + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + "]";
	}
		
	public void printTickets() {
		for(Ticket i : reimbursementTicketsList) {
			System.out.println("Tickets:" + i.getAmount() + " " + i.getDescription() 
							+ " " + i.getStatus());
		}
	}
	
}
