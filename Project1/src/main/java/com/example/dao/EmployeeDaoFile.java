package com.example.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.EmployeeDoesNotExistException;
import com.example.models.Employee;

public class EmployeeDaoFile implements EmployeeDao {

	private FileIO<List<Employee>> io;
	
	public EmployeeDaoFile() {
		this.io = new FileIO<List<Employee>>("employee.txt");
	}
	
	@Override
	public void addEmployee(Employee e) {
		
		List<Employee> eList = io.readOject();
		
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		eList.add(e);
		
		io.writeOject(eList);
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> eList = io.readOject();
		
		if(eList == null) {
			eList = new ArrayList<>();
		}
		return eList;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {

		List<Employee> eList = io.readOject();
		
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(Employee e: eList) {
			if(e.getEmail().equals(email)) {
				return e;
			}
		}
		//Instead of returning null, throw a new exception
		//return null;
		throw new EmployeeDoesNotExistException();
	}
	
/*
	@Override
	public void deleteEmployee(String email) {

		List<Employee> eList = io.readOject();
		
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(int i=0; i<eList.size(); i++) {
			if(eList.get(i).getEmail().equals(email)) {
				eList.remove(i);
				return;
			}
		}
		//Instead of returning null, throw a new exception
		//return null;
		throw new EmployeeDoesNotExistException();
	}

	@Override
	public void updateEmployee(Employee e) {

		List<Employee> eList = io.readOject();
		
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(int i=0; i<eList.size(); i++) {
			if(eList.get(i).getEmail().equals(e.getEmail())) {
				eList.remove(i);
				eList.add(e);
				return;
			}
		}
		//Instead of returning null, throw a new exception
		//return null;
		throw new EmployeeDoesNotExistException();
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
