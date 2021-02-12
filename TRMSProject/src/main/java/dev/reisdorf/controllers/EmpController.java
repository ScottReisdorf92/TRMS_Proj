package dev.reisdorf.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface EmpController {

	public void addEmployee(HttpServletRequest req, HttpServletResponse res);
	
	public void getAllEmployees(HttpServletRequest req, HttpServletResponse res);
	
	public void getEmployeeById(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void getEmployeeByUsername(HttpServletRequest req, HttpServletResponse res);
	
	public void getEmployeesBySupId(HttpServletRequest req, HttpServletResponse res);
	
	public void getEmployeesBySupUsername(HttpServletRequest req, HttpServletResponse res);
	
	public void getEmployeesByDeptId(HttpServletRequest req, HttpServletResponse res);
	
	public void getEmployeesByDeptName(HttpServletRequest req, HttpServletResponse res);
	
	public void updateEmployee(HttpServletRequest req, HttpServletResponse res);
	
	public void deleteEmpById(HttpServletRequest req, HttpServletResponse res);
	
	public void deleteEmpByUsername(HttpServletRequest req, HttpServletResponse res);
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void loggedInUser(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void viewSubordinate(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
