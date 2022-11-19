package com.example.dao;

import java.util.List;

import com.example.models.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee e) throws Exception;
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByEmail(String email, String password) throws Exception;
	public Employee getEmployeeById(int id);
	//public void deleteEmployee(String email);
	//public void updateEmployee(Employee e);
	
}
