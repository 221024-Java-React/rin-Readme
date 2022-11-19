package com.example.services;

import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.dao.TicketDao;
import com.example.models.Employee;
import com.example.models.EmployeeType;
import com.example.models.StatusType;
import com.example.models.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketService {

		private TicketDao ticketDao;
		//private ObjectMapper objectMapper;
		
		private EmployeeDao employeeDao;
		
		public TicketService(TicketDao ticketDao) {
			this.ticketDao = ticketDao;
		}
		
		public boolean registerATicket(String amount, String description, String e_id) {
			System.out.println(amount);
			try {
				return ticketDao.addTicket(Double.parseDouble(amount), description, Integer.valueOf(e_id));
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Employee does not exist");
			}
			return false;
		}
		
		public List<Ticket> getAllRegisteredTickets(){
			System.out.println("enters getallticks service");
			List<Ticket> tList = ticketDao.getAllTicket();

			for(int i=0; i<tList.size(); i++) {
				Ticket t = tList.get(i);
				System.out.println(t.toString());
				System.out.println(t.getEmployee_id().getId());
				try {	
					
					if(t.getEmployee_id()!=null) {
						try {
							t.setEmployee_id(employeeDao.getEmployeeById(tList.get(i).getId()));;
							tList.set(i, t);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}catch(NullPointerException ex) {
					ex.printStackTrace();
				}
			}
			return tList;
		}
		
		public List<Ticket> getRegisteredTicketsByStatus(StatusType status){
			System.out.println("Enters getticktsbystatus tickservice");
			int status2 = status.ordinal() + 1;
			System.out.println(status2);
						
			List<Ticket> tList = ticketDao.getTicketsByStatus(status2);

			for(int i=0; i<tList.size(); i++) {
				Ticket t = tList.get(i);
				try {	
					if((t.getEmployee_id()) != null) {
						try {
							t.setEmployee_id(employeeDao.getEmployeeById(t.getEmployee_id().getId()));
							tList.set(i, t);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}catch(NullPointerException ex) {
					ex.printStackTrace();
				}
			}
			return tList;
		}
		
		public boolean processingUpdatingTickets(String id, StatusType status, String m_id){
			System.out.println("Enters Ticket Service");
			//System.out.println(m_id.toString());
			int id2 = Integer.parseInt(id);
			int m_id2 = Integer.parseInt(m_id);
			
			Ticket t = new Ticket();
			Employee e = new Employee();
			
			try {
				e = this.ticketDao.isManagerAssoicate(m_id2);System.out.println(e);
				if((e != null) && (e.getType() == EmployeeType.MANAGER)) {
						t = this.ticketDao.getTicketById(id2);System.out.println(t.toString());
						if(t != null){
							System.out.println(id2);
							System.out.println(id2);
							if(status == StatusType.APPROVED || status == StatusType.DENIED) {
								t.setStatus(status);
							}
							System.out.println(t.getStatus());
							int status2 = t.getStatus().ordinal()+1;
							System.out.println(status2);
							ticketDao.updateTicket(t.getId(), status2); 
							return true;
						}
				}else System.out.println("Employee is not a manager");
			}catch(NullPointerException ex) {
				ex.printStackTrace();
				System.out.println("Enter catch in process Employee is not authorized");  
			}
			return false;
		}
		
		public void deleteATicket(Ticket t) {
			System.out.println("Enters Ticket Service");
				try {
					ticketDao.deleteTicket(t);
				} catch (Exception ex) {
					ex.printStackTrace();	
				}
		}	
}
