package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.Employee;

public interface EmployeeRepository {
	
	// Create operation(s)
	public Employee addEmployee(Employee emp);
	
	// Read operation(s)
	public List<Employee> getAllEmployees();
		
	public Employee getEmployeeById(int id);
	
	public Employee getEmployeeByUsername(String username);
	
	public List<Employee> getEmployeesBySupId(int id);
	
	public List<Employee> getEmployeesBySupUsername(String username);
	
	public List<Employee> getEmployeesByDeptId(int id);
	
	public List<Employee> getEmployeesByDeptName(String name);
	
	
	// Update operation(s)
	public Employee updateEmployee(Employee emp);
	
	// Delete operations
	public boolean deleteEmpById(int id);
	
	public boolean deleteEmpByUsername(String username);
}
