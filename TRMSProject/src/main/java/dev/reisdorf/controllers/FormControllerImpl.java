package dev.reisdorf.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.reisdorf.model.Department;
import dev.reisdorf.model.EmpEvent;
import dev.reisdorf.model.Employee;
import dev.reisdorf.model.RForm;
import dev.reisdorf.services.DeptService;
import dev.reisdorf.services.DeptServiceImpl;
import dev.reisdorf.services.EmpService;
import dev.reisdorf.services.EmpServiceImpl;
import dev.reisdorf.services.EventService;
import dev.reisdorf.services.EventServiceImpl;
import dev.reisdorf.services.FormService;
import dev.reisdorf.services.FormServiceImpl;
import dev.reisdorf.services.GradeService;
import dev.reisdorf.services.GradeServiceImpl;

public class FormControllerImpl implements FormController {

	private static EmpService es = new EmpServiceImpl();
	private static DeptService ds = new DeptServiceImpl();
	private static EventService evs = new EventServiceImpl();
	private static FormService fs = new FormServiceImpl();
	private static GradeService gs = new GradeServiceImpl();
	private static Gson gson = new Gson();
	
	
	@Override
	public void getUserFormInfo(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		String username;
		//res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"supervisor\": " + gson.toJson(s) + ,);
		if(cookies == null) {
			res.getWriter().append("{}");
		} else {
			Employee e = null;
			Department d = null;
			EmpEvent ev = null;
			RForm form = null;
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				System.out.println(cookie.getName() + "=" + cookie.getValue());
				
				if (cookie.getName().equals("loggedInUser")) {
					System.out.println(cookie.getValue());
					username = cookie.getValue();
					e = es.getEmployeeByUsername(username);
					d = ds.getDeptById(e.getDeptId());
	
				} else if (cookie.getName().equals("formId")) {
					System.out.println(cookie.getValue());
					form = fs.getFormById(Integer.parseInt(cookie.getValue()));
					ev = evs.getEventById(form.getEventId());
				}
				
			}
			res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"department\": " + gson.toJson(d) +
					", \"event\": " + gson.toJson(ev) + ", \"form\": " + gson.toJson(form) + "}");
		}

	}

	@Override
	public void deleteForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String fid = req.getParameter("fid");
		
		int id;
		try {
			id = Integer.parseInt(fid);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.sendError(400, "Employee ID parameter formatted incorrectly");
			return;
		}
		RForm form = fs.getFormById(id);
		fs.deleteForm(id);
		evs.deleteEvent(form.getEventId());
		
		res.getWriter().append("true");
		
	}

	@Override
	public void updateApproval(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		RForm form = gson.fromJson(req.getReader(), RForm.class);
		System.out.println(form);
		
		if (form.getFinAppr().equals("APPROVED")) {
			HashMap<String, Double> rmbtAmts = new HashMap<String, Double>();
			rmbtAmts.put("UNIV_COURSE", 0.80);
			rmbtAmts.put("SEMINAR", 0.60);
			rmbtAmts.put("CERTIFICATION PREP CLASS", 0.75);
			rmbtAmts.put("CERT", 1.00);
			rmbtAmts.put("TECH TRAINING", 0.90);
			rmbtAmts.put("OTHER", 0.30);
			Employee e = es.getEmployeeById(form.getEmpId());
			EmpEvent event = evs.getEventById(form.getEventId());
			Double typeAmt = rmbtAmts.get(event.getEventType());
			
			if(e.getAvailAmt() > (typeAmt * event.getCost())) {
				e.setAvailAmt(e.getAvailAmt()-(typeAmt * event.getCost()));
			} else {
				e.setAvailAmt(0);
			}
			es.updateEmployee(e);
		}
		
		form = fs.updateForm(form);
		res.getWriter().append((form != null) ? gson.toJson(form) : "{}");
	}

	@Override
	public void submitGrade(HttpServletRequest req, HttpServletResponse res) throws IOException {

		RForm form = gson.fromJson(req.getReader(), RForm.class);
		System.out.println(form);
		form = fs.updateForm(form);
		
		res.getWriter().append(gson.toJson(form));
		
	}

	@Override
	public void addEvent(HttpServletRequest req, HttpServletResponse res) throws IOException {
		EmpEvent event = gson.fromJson(req.getReader(), EmpEvent.class);
		System.out.println(event);
		event = evs.addEvent(event);
		System.out.println(event);
		res.getWriter().append(gson.toJson(event));
		
	}

	@Override
	public void addForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		RForm form = gson.fromJson(req.getReader(), RForm.class);
		System.out.println(form);
		form = fs.addForm(form);
		System.out.println(form);
		res.getWriter().append(gson.toJson(form));
		
	}

}
