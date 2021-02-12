package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.Department;

public interface DeptRepository {

	// Create
	public Department addDept(Department dept);
	
	// Read
	public List<Department> getAllDepts();
	
	public Department getDeptById(int id);
	
	public Department getDeptByName(String name);
	
	public Department getDeptByHeadId(int id);
	
	// Update
	public Department updateDept(Department dept);
	
	// Delete
	public boolean delDeptById(int id);
	
	public boolean delDeptByName(String deptName);
}
