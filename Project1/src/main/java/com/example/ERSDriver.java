package com.example;

import com.example.controllers.EmployeeController;
import com.example.controllers.TicketController;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoJDBC;
import com.example.dao.TicketDao;
import com.example.dao.TicketDaoJDBC;
import com.example.exceptions.EmployeeAlreadyExistException;
import com.example.exceptions.EmployeeDoesNotExistException;
import com.example.services.EmployeeService;
import com.example.services.TicketService;

import io.javalin.Javalin;

public class ERSDriver {

	public static void main(String[] args) {

		//EmployeeDao eDao = new EmployeeDaoFile();
		EmployeeDao eDao = new EmployeeDaoJDBC();
		EmployeeService eServ = new EmployeeService(eDao);
		EmployeeController eController = new EmployeeController(eServ);
		
		TicketDao tDao = new TicketDaoJDBC();
		TicketService tServ = new TicketService(tDao);
		TicketController tController = new TicketController(tServ);
		
		Javalin app = Javalin.create(config->{
			config.plugins.enableCors(cors->{
				cors.add(it-> {
					it.anyHost();
				});
			});
		});
		
		//Here we would have our routes/handlers
		app.get("/hello", (ctx)->(ctx).result("Hello world i live in az"));
		
		app.post("/employee/register", eController.handleRegister);
		app.get("/employee/", eController.handleGetAll);
		app.post("/employee/login", eController.handleLogin);
		//app.delete("/employee/", eController.handleDelete);
		//app.put("/employee/", eController.handleUpdate);
		
		//We can also register handlers to deal with exceptions
		//app.exception(EmployeeDoesNotExistException.class, (ex, context) -> {
		//context.status(401);
		//context.result("You were unable to login");
		//});
				
		//app.exception(EmployeeAlreadyExistException.class, (ex, context)-> {
		//context.status(409);
		//context.result("You are not able to register an account with an email which already exists");
		//});
		
		app.post("/ticket/submit", tController.handleSubmitTicket);
		app.get("/ticket/", tController.handleGetAllTicket);
		app.get("/ticket/status", tController.handleGetAllTicketByStatus);
		
		app.patch("/ticket/", tController.handleUpdateTicket);
		app.delete("/ticket/", tController.handleDeleteATicket);
		
		
		//finally we start the application
		app.start(8001);
		
		/*
		Employee e1, e2;
		Manager m1;
		e1 = new Employee ("Tom", "Arnold", 111223334, "tom@mail.com", "password");
		e2 = new Employee ("Sassy", "Lassy", 111223334, "sassy@mail.com", "password");
		m1 = new Manager ("Rin", "Chheng", 111223334, "rin@mail.com", "password");
		
		e1.submitReimbursementTicket(16.98, "New Hire Conference");
		e1.submitReimbursementTicket(34.32, "gas");
		e2.submitReimbursementTicket(3.43, "1 ream of paper");
		
		System.out.println(e1.toString());
		e1.printTickets();
		System.out.println(e2.toString());
		e2.printTickets();
		System.out.println(m1.toString());
		
		m1.processReimbursementTicket("approved");
		*/	
	}

}
