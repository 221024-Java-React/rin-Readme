package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Employee;
import com.example.models.StatusType;
import com.example.models.Ticket;

public interface TicketDao {
	public boolean addTicket(double amount, String description, int e_id) throws SQLException;
	public List<Ticket> getAllTicket();
	public Ticket getTicketById(int id);
	public List<Ticket> getTicketsByStatus(int status);
	public Employee isManagerAssoicate(int e_id);
	public void updateTicket(int id, int status);
	public void deleteTicket(Ticket t) throws Exception;
	
}
