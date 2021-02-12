package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.RForm;

public interface FormService {
	
	public List<RForm> getFormsByEmpId(int id);
	
	public RForm getFormById(int id);
	
	public RForm updateForm(RForm form);

	public boolean deleteForm(int id);
	
	public RForm addForm(RForm form);
	
	
}
