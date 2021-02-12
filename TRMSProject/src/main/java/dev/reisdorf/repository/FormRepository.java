package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.RForm;

public interface FormRepository {
	
	// Create
	public RForm addRForm(RForm form);
	
	// Read
	public List<RForm> getAllForms();
	
	public List<RForm> getFormsByEmpId(int id);
	
	public List<RForm> getFormsByEmpUsername(String username);
	
	public RForm getRFormById(int id);
	
	// Update
	public RForm updateForm(RForm form);
	
	// Delete
	public boolean deleteFormById(int id);
	
	public boolean deleteFormByEmpId(int formId, int empId);
	
	public boolean deleteFormByUsername(int formId, String username);
	
}
