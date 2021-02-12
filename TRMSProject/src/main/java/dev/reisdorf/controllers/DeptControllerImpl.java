package dev.reisdorf.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.reisdorf.model.Department;
import dev.reisdorf.services.DeptService;
import dev.reisdorf.services.DeptServiceImpl;


public class DeptControllerImpl implements DeptController {
	
	private static DeptService ds = new DeptServiceImpl();
	private static Gson gson = new Gson();
	
	@Override
	public void getDeptById(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String input = req.getParameter("did");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.sendError(400, "Employee ID parameter formatted incorrectly");
			return;
		}
		
		Department d = ds.getDeptById(id);
		res.getWriter().append((d != null) ? gson.toJson(d) : "{}");

	}

}
