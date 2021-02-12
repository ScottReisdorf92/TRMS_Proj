package dev.reisdorf.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DeptController {
	
	public void getDeptById(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
