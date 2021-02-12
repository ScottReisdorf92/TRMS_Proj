package dev.reisdorf.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FormController {
	
	public void getUserFormInfo(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void deleteForm(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void updateApproval(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void submitGrade(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void addEvent(HttpServletRequest req, HttpServletResponse res) throws IOException;
	
	public void addForm(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
