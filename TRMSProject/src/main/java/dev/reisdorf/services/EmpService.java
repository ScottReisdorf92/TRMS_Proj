package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.Employee;

public interface EmpService {
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public Employee getEmployeeByUsername(String username);
	
	public List<Employee> getEmployeesBySupId(int id);
	
	public List<Employee> getEmployeesBySupUsername(String username);
	
	public List<Employee> getEmployeesByDeptId(int id);
	
	public List<Employee> getEmployeesByDeptName(String name);
	
	public Employee updateEmployee(Employee emp);
	
	public boolean deleteEmpById(int id);
	
	public boolean deleteEmpByUsername(String username);
	
	public Employee login(String username, String password);
}
