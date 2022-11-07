package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.exceptions.EmployeeAlreadyExistException;
import com.example.exceptions.EmployeeDoesNotExistException;
import com.example.models.Employee;
import com.example.utils.LoggingUtil;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void registerEmployee(Employee e) {
		try {
			employeeDao.addEmployee(e);
			LoggingUtil.getLogger().warn("User: " + e + " was registered");
		} catch(Exception ex) {
			System.out.println("Enters the employee exist catch");
			LoggingUtil.getLogger().warn("User with email " + e.getEmail() + " tried to register a second time");
			throw new EmployeeAlreadyExistException();
		}
	}
	
	public List<Employee> getAllRegistered(){
		return employeeDao.getAllEmployee();
	}
	
/*	public Employee login(String email) {
		Employee e = employeeDao.getEmployeeByEmail(email);
		
		if(e == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			//Instead of returning null, we could throw an exception and allow Javalin to send a custom response
			throw new EmployeeDoesNotExistException();
		}
		
		//insert validation logic here
		//p = new Person();
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return e;
	}
	
	public void removeEmployee(String email) {
		employeeDao.deleteEmployee(email);
		LoggingUtil.getLogger().info("User " + email + " was removed from the system");
	}
	
	public void updateEmployee(Employee e) {
		employeeDao.updateEmployee(e);
		LoggingUtil.getLogger().info("User " + e.getId() + " was successfully updated in the system");
	}*/

}