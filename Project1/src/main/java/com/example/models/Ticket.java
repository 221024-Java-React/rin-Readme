package com.example.models;

public class Ticket {
	private int id;
	private StatusType status;
	private double amount;
	private String description;
	//private int employee_id;
	private Employee employee_id;
	
	public Ticket() {
		super();
		this.status = StatusType.PENDING;
	}
	
	public Ticket(int id, StatusType status, double amount, String description, Employee employee_id) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.description = description;
		this.employee_id = employee_id;
	}

	public Ticket(StatusType status, double amount, String description, Employee employee_id) {
		super();
		this.status = status;
		this.amount = amount;
		this.description = description;
		this.employee_id = employee_id;
	}
	
	public Ticket(double amount, String description, Employee employee_id) {
		super();
		this.amount = amount;
		this.description = description;
		this.employee_id = employee_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Employee employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", status=" + status + ", amount=" + amount + ", description=" + description
				+ ", employee_id=" + employee_id + "]";
	}
}
