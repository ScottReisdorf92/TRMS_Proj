package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.Employee;
import dev.reisdorf.repository.EmployeeRepository;
import dev.reisdorf.repository.EmployeeRepositoryImpl;

public class EmpServiceImpl implements EmpService {
	
	private static EmployeeRepository emprepo = new EmployeeRepositoryImpl();
	
	@Override
	public Employee addEmployee(Employee emp) {
		return emprepo.addEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return emprepo.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return emprepo.getEmployeeById(id);
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return emprepo.getEmployeeByUsername(username);
	}

	@Override
	public List<Employee> getEmployeesBySupId(int id) {
		return emprepo.getEmployeesBySupId(id);
	}

	@Override
	public List<Employee> getEmployeesBySupUsername(String username) {
		return emprepo.getEmployeesBySupUsername(username);
	}

	@Override
	public List<Employee> getEmployeesByDeptId(int id) {
		return emprepo.getEmployeesByDeptId(id);
	}

	@Override
	public List<Employee> getEmployeesByDeptName(String name) {
		return emprepo.getEmployeesByDeptName(name);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return emprepo.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmpById(int id) {
		return emprepo.deleteEmpById(id);
	}

	@Override
	public boolean deleteEmpByUsername(String username) {
		return emprepo.deleteEmpByUsername(username);
	}

	@Override
	public Employee login(String username, String password) {
		Employee e = emprepo.getEmployeeByUsername(username);
		
		if (e != null && (e.getPassword().equals(password))) {
			return e;
		}
		return null;
	}

}
