package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.EmpAttach;

public interface AttachRepository {
	
	// Create
	public EmpAttach addAttachment(EmpAttach attach);
	
	// Read 
	public List<EmpAttach> getAllAttachments();
	
	public List<EmpAttach> getAllFormAttachments(int id);
	
	// Update
	
	// delete
	public boolean deleteAttachment(int id, String attachName);
	
	public boolean deleteFormAttachments(int id);
}
