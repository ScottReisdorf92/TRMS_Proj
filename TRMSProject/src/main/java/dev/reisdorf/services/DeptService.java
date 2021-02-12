package dev.reisdorf.services;

import dev.reisdorf.model.Department;

public interface DeptService {
	
	public Department getDeptById(int id);
	
	public boolean isDeptHead(int id);
}
