package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.EmpEvent;

public interface EventService {
	
	public List<EmpEvent> getEventsByEmpId(int id);
	
	public EmpEvent getEventById(int id);

	public boolean deleteEvent(int eventId);
	
	public EmpEvent addEvent(EmpEvent event);
}
