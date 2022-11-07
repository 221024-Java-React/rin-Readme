
/*public class EmployeeDaoJDBC {

}*/
package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Employee;
import com.example.models.EmployeeType;
import com.example.utils.JDBCConnectionUtil;

public class EmployeeDaoJDBC implements EmployeeDao {
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void addEmployee(Employee e) throws SQLException{

		//We need a connection to create a statment
		Connection connection = conUtil.getConnection();
		
		int type = e.getType().ordinal() + 1;
		type = 1;
	
		//The actual SQL query we want to execute
		String sql = "INSERT INTO employee (type, first_name, last_name, email, password) VALUES"
				+ "(" + type + ",'" + e.getFirstName() +"','" + e.getLastName() + "','" +
				e.getEmail() + "','" + e.getPassword() + "')";
	
		//Get the statement to actually make our query
		Statement statement = connection.createStatement();
		
		//Execute the SQL query
		statement.execute(sql);
	
	/*
		//PreparedStatement prepared;
		try {
		if(checkEmailIsAvailable(e.getEmail())) {
			
				
			
			
			
			String sql =" insert into employee (type, first_name, last_name, email, password)"
				+ " values(?,?,?,?,?)";
		
			prepared = connection.prepareStatement(sql);
		
			int type = e.getType().ordinal() + 1;
		
			prepared.setInt(1, type);
			prepared.setString(2, e.getFirstName());
			prepared.setString(3, e.getLastName());
			prepared.setString(4, e.getEmail());
			prepared.setString(5, e.getPassword());
		
			prepared.execute(sql);
			return false;
			
		}else {
			System.out.println("email already exist");
		}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		*/
	}
		
	public boolean checkEmailIsAvailable(String email) throws SQLException {
		Connection connection = conUtil.getConnection();
		
		PreparedStatement prepared;
		
		String sql = "select * from employee where email='" + email + "'";
		prepared = connection.prepareStatement(sql);
		ResultSet result = prepared.executeQuery();
		if (result.next())
			return false;
		return true;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> eList = new ArrayList();

		try {
			
			//We need a connection to create a statment
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee";
			
			Statement statement = connection.createStatement();
			
			//When we are returning data from a query, we need to store that data in a ResultSet
			//ResultSet will essentially return a collection of rows with your data
			ResultSet result = statement.executeQuery(sql);
			
			//We need to loop through our result set and return the list of people
			while(result.next()) {
				Employee e = new Employee();
				//JDBC indexes from 1
				e.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					e.setType(EmployeeType.ASSOCIATE);
				}else {
					e.setType(EmployeeType.MANAGER);
				}
				
				e.setFirstName(result.getString(3));
				e.setLastName(result.getString(4));
				e.setEmail(result.getString(5));
				e.setPassword(result.getString(6));
				
				eList.add(e);
			}
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return eList;
	}

/*	@Override
	public Employee getEmployeeByEmail(String email) {
		Employee e = null;
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				e = new Employee();
				e.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					e.setType(EmployeeType.ASSOCIATE);
				}else {
					e.setType(EmployeeType.MANAGER);
				}
				
				e.setFirstName(result.getString(3));
				e.setLastName(result.getString(4));
				e.setEmail(result.getString(5));
				e.setPassword(result.getString(6));
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return e;
	}

	@Override
	public void deleteEmployee(String email) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "DELETE FROM employee WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			int type = e.getType().ordinal() + 1;
			
			String sql = "UPDATE employee SET type ="  + type + ",first_name = '" + e.getFirstName() + 
					"', last_name ='" + e.getLastName() + "', email='" + e.getEmail() + "', password='" +
					e.getPassword() + "' WHERE id =" + e.getId();
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee e = null;

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE id=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				e = new Employee();
				e.setId(result.getInt(1));
				
				if(result.getInt(2) == 1) {
					e.setType(EmployeeType.ASSOCIATE);
				}else {
					e.setType(EmployeeType.MANAGER);
				}
				
				e.setFirstName(result.getString(3));
				e.setLastName(result.getString(4));
				e.setEmail(result.getString(5));
				e.setPassword(result.getString(6));
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}

		return e;
	}*/

}
