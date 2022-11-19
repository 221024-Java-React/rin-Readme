package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.models.Employee;
import com.example.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class EmployeeController {
	
	private EmployeeService eServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public EmployeeController(EmployeeService eServ) {
		this.eServ = eServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		
		Employee e = objectMapper.readValue(context.body(), Employee.class);
		
		System.out.println(e);
		
		boolean emailExist = eServ.registerEmployee(e);
		 if(emailExist == false) {
			 context.status(403);
			 context.result(objectMapper.writeValueAsString("Invalid entry"));
		 }else {
			 //Set our status code to OK
			 context.status(201);
			 context.result(objectMapper.writeValueAsString(e));
		 }
	};
	
	public Handler handleGetAll = (context) -> {
		List<Employee> eList = eServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(eList));
	};
	
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Employee loggedIn = eServ.login(body.get("email"), body.get("password"));
		
		if(loggedIn==null)
			context.status(404);
		else {
		context.status(200);
		context.result(objectMapper.writeValueAsString(loggedIn.getFirstName() + " " + loggedIn.getLastName() +" is logged in!"));
		}
	};
	
	/*
	public Handler handleDelete = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		eServ.removeEmployee(body.get("email"));
		
		context.status(200);
		context.result("Person was removed");
	};
	
	public Handler handleUpdate = (context) -> {
		Employee e = objectMapper.readValue(context.body(), Employee.class);
		
		eServ.updateEmployee(e);
		
		context.status(200);
		context.result("Persons information was updated");
	};*/

}