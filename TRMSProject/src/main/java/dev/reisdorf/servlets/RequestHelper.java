package dev.reisdorf.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.reisdorf.controllers.DeptController;
import dev.reisdorf.controllers.DeptControllerImpl;
import dev.reisdorf.controllers.EmpController;
import dev.reisdorf.controllers.EmpControllerImpl;
import dev.reisdorf.controllers.FormController;
import dev.reisdorf.controllers.FormControllerImpl;


public class RequestHelper {

	/**
	 * This method will delegate other methods on the controller layer of our application to process the request.
	 * @param request the HTTP request
	 * @param response the HTTP response 
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		EmpController ec = new EmpControllerImpl();
		DeptController dc = new DeptControllerImpl();
		FormController fc = new FormControllerImpl();
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch (uri) {
		
		case "/TRMSProject/getEmployee.do": {
			//ec.getEmployee(request, response);
			break;
		} case "/TRMSProject/login.do": {
			ec.login(request, response);
			break;
		} case "/TRMSProject/loggedInUser.do": {
			ec.loggedInUser(request, response);
			break;
		} case "/TRMSProject/getSup.do": {
			ec.getEmployeeById(request, response);
			break;
		} case "/TRMSProject/viewEmployee.do": {
			ec.viewSubordinate(request, response);
			break;
		} case "/TRMSProject/getDept.do": {
			dc.getDeptById(request, response);
			break;
		} case "/TRMSProject/userForm.do": {
			fc.getUserFormInfo(request, response);
			break;
		}  case "/TRMSProject/submitGrade.do": {
			fc.submitGrade(request, response);
			break;
		} case "/TRMSProject/addEvent.do": {
			fc.addEvent(request, response);
			break;
		} case "/TRMSProject/addForm.do": {
			fc.addForm(request, response);
			break;
		} case "/TRMSProject/deleteForm.do": {
			fc.deleteForm(request, response);
			break;
		} case "/TRMSProject/approval.do": {
			fc.updateApproval(request, response);
			break;
		} case "/TRMSProject/logout.do": {
			ec.logout(request, response);
			break;
		} default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, am teapot");
			break;
		}
		}
	}
}
