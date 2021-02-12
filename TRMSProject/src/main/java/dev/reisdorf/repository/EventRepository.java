package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.EmpEvent;

public interface EventRepository {
	
	// Create
	public EmpEvent addEvent(EmpEvent event);
	
	// Read
	public List<EmpEvent> getAllEvents();
	
	public List<EmpEvent> getEventsByEmpId(int id);
	
	public List<EmpEvent> getEventsByEmpUsername(String username);
	
	public EmpEvent getEventById(int id);
	
	// Update
	public EmpEvent updateEvent(EmpEvent event);
	
	// Delete
	public boolean deleteEventById(int id);
	
	public boolean deleteEventByUsername(int id, String username);
	
	public boolean deleteEventByEmpId(int eventId, int empId);

}
