package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.TicketDoesNotExistException;
import com.example.models.Employee;
import com.example.models.EmployeeType;
import com.example.models.StatusType;
import com.example.models.Ticket;
import com.example.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao{
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	Connection connection = conUtil.getConnection();
	
	@Override
	public boolean addTicket(double amount, String description, int e_id) throws SQLException{
		System.out.println("Enters addTicket Exception");
		Employee e = new Employee();
		e = isManagerAssoicate(e_id);
		System.out.println(e.toString());
		Statement statement;
		
		if(e != null) {
				try {
					int status = StatusType.PENDING.ordinal() + 1;
					Connection connection = conUtil.getConnection();
					
					String sql = "INSERT INTO ticket (status, amount, description, employee_id)"
							+ "VALUES (?,?,?,?)";
					
					PreparedStatement prepared = connection.prepareStatement(sql);
					
					prepared.setInt(1, status);
					prepared.setDouble(2,  amount);
					prepared.setString(3, description);
					prepared.setInt(4, e_id);
					
					prepared.execute();
				
					return true;
				}catch (SQLException ex) {
					ex.printStackTrace();
				}	
		}
		return false;
	}
	
	public boolean checkTicketIsAvailable() {
		PreparedStatement prepared;
		//Ticket t = new Ticket();
		String sql = "SELECT * FROM Ticket";
		
		try {
			prepared = connection.prepareStatement(sql);
			ResultSet result = prepared.executeQuery();
			if(result.next())
				return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> tList = new ArrayList();
		
		try {
			String sql = "SELECT * FROM ticket ORDER BY id";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t2 = new Ticket();
				//JDBC indexes from 1
				t2.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					t2.setStatus(StatusType.PENDING);
				}else if(result.getInt(2)==2){
					t2.setStatus(StatusType.APPROVED);
				}else
					t2.setStatus(StatusType.DENIED);
				
				t2.setAmount(result.getDouble(3));
				t2.setDescription(result.getString(4));
				if(result.getObject(5) == null) {
					t2.setEmployee_id(null);
				}else {
					Employee e = new Employee();
					e.setId(result.getInt(5));
					t2.setEmployee_id(e);
				}
				tList.add(t2);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return tList;
	} 
	
	@Override
	public Ticket getTicketById(int id){
		 String sql = "SELECT * FROM ticket WHERE id = ?";
	        try (Connection connection = conUtil.getConnection()) {
	            PreparedStatement prepared = connection.prepareStatement(sql);
	            prepared.setInt(1, id);
	            ResultSet result = prepared.executeQuery();
	            if (result.next()) {
	            	Ticket t2 = new Ticket();
					//JDBC indexes from 1
					t2.setId(result.getInt(1));
					
					if(result.getInt(2) == 1) {
						t2.setStatus(StatusType.PENDING);
					}else if(result.getInt(2)==2){
						t2.setStatus(StatusType.APPROVED);
					}else
						t2.setStatus(StatusType.DENIED);
					
					t2.setAmount(result.getDouble(3));
					t2.setDescription(result.getString(4));
					if(result.getObject(5) == null) {
						t2.setEmployee_id(null);
					}else {
						Employee e = new Employee();
						e.setId(result.getInt(5));
						t2.setEmployee_id(e);
					}
	                
					return t2;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	}
	
	@Override
	public List<Ticket> getTicketsByStatus(int status) {
		System.out.println("Enters getticktsbystatus tickdao");
		List<Ticket> tList = new ArrayList();
		Statement statement;
		try {
			
			String sql = "SELECT * FROM ticket t INNER JOIN employee e ON t.employee_id = e.id " 
					+" WHERE t.status = " + status;
			
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Ticket t2 = new Ticket();
				//JDBC indexes from 1
				t2.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					t2.setStatus(StatusType.PENDING);
				}else if(result.getInt(2)==2){
					t2.setStatus(StatusType.APPROVED);
				}else
					t2.setStatus(StatusType.DENIED);
				
				t2.setAmount(result.getDouble(3));
				t2.setDescription(result.getString(4));
				if(result.getObject(5) == null) {
					t2.setEmployee_id(null);
				}else {
					Employee e = new Employee();
					e.setId(result.getInt(5));
					t2.setEmployee_id(e);
				}
				tList.add(t2);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return tList;
	}
		
	@Override
	public Employee isManagerAssoicate(int m_id) {
		try {
			String sql = "SELECT * FROM employee WHERE id = ?";
			Connection connection = conUtil.getConnection();
		
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setInt(1, m_id);
			ResultSet result = prepared.executeQuery();
			if(result.next()) {
				Employee e = new Employee();
				//JDBC indexes from 1
				e.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					e.setType(EmployeeType.ASSOCIATE);
				}else
					e.setType(EmployeeType.MANAGER);
				
				e.setFirstName(result.getString(3));
				e.setLastName(result.getString(4));
				e.setPassword(result.getString(5));
				e.setEmail(result.getString(6));
                
				return e;	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateTicket(int id, int status) {
		System.out.println("Enters TicketJDBC Update tickets");
		System.out.println(id);
		System.out.println(status);
		try {
			String sql = "update ticket SET status = ? where status=? and id = ?";

			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, status);
			prepared.setInt(2, 1);
			prepared.setInt(3, id);
			System.out.println(prepared);
			prepared.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteTicket(Ticket t) {
		System.out.println("Enters TicketJDBC");
		Statement statement;
		String sql = "DELETE FROM ticket WHERE id=" + t.getId();
		try {
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
