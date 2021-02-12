package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.EmpEvent;
import dev.reisdorf.repository.EventRepository;
import dev.reisdorf.repository.EventRepositoryImpl;

public class EventServiceImpl implements EventService {
	
	private static EventRepository er = new EventRepositoryImpl();
	@Override
	public List<EmpEvent> getEventsByEmpId(int id) {
		return er.getEventsByEmpId(id);
	}
	@Override
	public EmpEvent getEventById(int id) {
		return er.getEventById(id);
	}
	@Override
	public boolean deleteEvent(int eventId) {
		return er.deleteEventById(eventId);
	}
	@Override
	public EmpEvent addEvent(EmpEvent event) {
		return er.addEvent(event);
	}

}
