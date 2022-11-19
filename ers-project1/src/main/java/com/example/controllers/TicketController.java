package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.models.Employee;
import com.example.models.StatusType;
import com.example.models.Ticket;
import com.example.services.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class TicketController {
	
	private TicketService tServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public TicketController(TicketService tServ) {
		this.tServ = tServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleSubmitTicket = (context) -> {
		System.out.println("Enters submit ticket handle");
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		System.out.println(body);
		String amount = String.valueOf(body.get("amount"));
		String description = String.valueOf(body.get("description"));
		String e_id = String.valueOf(body.get("employee_id"));
		
		boolean ticketExist = tServ.registerATicket(amount, description, e_id);
		
		if(ticketExist !=  true) {
			context.status(403);
			context.result(objectMapper.writeValueAsString("Invalid entry"));
		}else {
			 //Set our status code to OK
			context.status(201);
			context.result(objectMapper.writeValueAsString("Ticket Submitted successfully"));
		}
	};
	
	public Handler handleGetAllTicket = (context) -> {
		
		List<Ticket> tList = tServ.getAllRegisteredTickets();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
		
	};
	
	public Handler handleGetAllTicketByStatus = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		System.out.println("Enters getticktsbystatus tickcontroller");
		List<Ticket> tList = tServ.getRegisteredTicketsByStatus(t.getStatus());
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	public Handler handleUpdateTicket = (context)-> {
		System.out.println("Enters Ticket Controller");
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		System.out.println(body);
		
		//try {
		StatusType status2 = StatusType.PENDING;
		switch(body.get("status")) {
		case "APPROVED" : status2 = StatusType.APPROVED;
			break;
		case "DENIED": status2 = StatusType.DENIED;
			break;
		default:
			break;
		}
		
		String id = String.valueOf(body.get("id"));
		String m_id = String.valueOf(body.get("manager_id"));
		
		System.out.println(id);
		System.out.println(m_id);
		
		boolean isValidTicket = tServ.processingUpdatingTickets(id, status2, m_id);
		
		if(isValidTicket == true)
		{
			context.status(200);
			context.result(objectMapper.writeValueAsString(body + "Thank you for processing ticket"));
		}else {
			context.status(403);
			context.result(objectMapper.writeValueAsString("Invalid entry"));
		}
		
	};
	

	public Handler handleDeleteATicket = (context) -> {
		System.out.println("Enters Ticket controller");
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		tServ.deleteATicket(t);
		
		context.status(200);
		context.result(objectMapper.writeValueAsString("Delete was Successful"));
	};
	

}
