package com.example.models;

public class Ticket {
	private int id;
	private int status;
	private double amount;
	private String description;
	
	public Ticket() {
		super();
	}
	
	public Ticket(int id, int status, double amount, String description) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.description = description;
	}

	public Ticket(int status, double amount, String description) {
		super();
		this.status = status;
		this.amount = amount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", status=" + status + ", amount=" + amount + ", description=" + description + "]";
	}
}
