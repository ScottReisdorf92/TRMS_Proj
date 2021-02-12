package dev.reisdorf.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.reisdorf.model.Department;
import dev.reisdorf.model.EmpEvent;
import dev.reisdorf.model.Employee;
import dev.reisdorf.model.Grade;
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

public class EmpControllerImpl implements EmpController {

	private static EmpService es = new EmpServiceImpl();
	private static DeptService ds = new DeptServiceImpl();
	private static EventService evs = new EventServiceImpl();
	private static FormService fs = new FormServiceImpl();
	private static GradeService gs = new GradeServiceImpl();
	private static Gson gson = new Gson();
	
	@Override
	public void addEmployee(HttpServletRequest req, HttpServletResponse res) {
		
	}

	@Override
	public void getAllEmployees(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void getEmployeeById(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String input = req.getParameter("eid");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.sendError(400, "Employee ID parameter formatted incorrectly");
			return;
		}
		
		Employee e = es.getEmployeeById(id);
		res.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	@Override
	public void getEmployeeByUsername(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void getEmployeesBySupId(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void getEmployeesBySupUsername(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void getEmployeesByDeptId(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void getEmployeesByDeptName(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void updateEmployee(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void deleteEmpById(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void deleteEmpByUsername(HttpServletRequest req, HttpServletResponse res) {

	}
	
	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//String username = req.getParameter("username");
		//String password = req.getParameter("password");
		
		Employee e = gson.fromJson(req.getReader(), Employee.class);
		e = es.login(e.getUsername(), e.getPassword());
		//Employee e = es.login(username, password);
		System.out.println(gson.toJson(e));
		if (e != null) {
			Cookie cookie = new Cookie("loggedInUser", e.getUsername());
			cookie.setSecure(true);
			res.addCookie(cookie);
			
			res.getWriter().append(gson.toJson(e));
		} else {
			res.getWriter().append("{}");
		}
//		HttpSession session = req.getSession();
//		session.setAttribute("loggedInUser", (e != null) ? gson.toJson(e) : "{}");
//		res.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	@Override
	public void loggedInUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		String username;
		//res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"supervisor\": " + gson.toJson(s) + ,);
		if(cookies == null) {
			res.getWriter().append("{}");
		} else {
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				if (cookie.getName().equals("loggedInUser")) {
					System.out.println(cookie.getValue());
					username = cookie.getValue();
					Employee e = es.getEmployeeByUsername(username);
					Employee s = es.getEmployeeById(e.getSupId());
					Department d = ds.getDeptById(e.getDeptId());
					List<EmpEvent> ev = evs.getEventsByEmpId(e.getEmpId());
					List<RForm> forms = fs.getFormsByEmpId(e.getEmpId());
					List<Employee> subordinates;
					if (e.getEmpId() == 3) {
						subordinates = es.getAllEmployees();
						for (int j = 0; j < subordinates.size(); j++) {
							if (subordinates.get(j).getEmpId() == e.getEmpId()) {
								subordinates.remove(j);
							}
						}
					} else if (ds.isDeptHead(e.getEmpId())) {
						subordinates = es.getEmployeesByDeptId(e.getDeptId()); // fix
						for (int j = 0; j < subordinates.size(); j++) {
							if (subordinates.get(j).getEmpId() == e.getEmpId()) {
								subordinates.remove(j);
							}
						}
					} else {
						subordinates = es.getEmployeesBySupId(e.getEmpId());
					}
					
					res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"supervisor\": " + gson.toJson(s) + ", \"department\": " + gson.toJson(d) +
							", \"events\": " + gson.toJson(ev) + ", \"forms\": " + gson.toJson(forms) + 
							", \"subordinates\": " + ((subordinates != null) ? gson.toJson(subordinates) : "{}") +"}");
					break;
				}
			}
		}
	}

	@Override
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		
		for(int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if (cookie.getName().equals("loggedInUser")) {
				System.out.println(cookie.getValue());
				cookie.setMaxAge(0);
				res.addCookie(cookie);
				break;
			}
		}
		
	}

	@Override
	public void viewSubordinate(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		String username;
		//res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"supervisor\": " + gson.toJson(s) + ,);
		if(cookies == null) {
			res.getWriter().append("{}");
		} else {
			Employee e = null;
			Employee s = null;
			Department d = null;
			Employee sub = null;
			List<EmpEvent> ev = null;
			List<RForm> forms = null;
			
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				if (cookie.getName().equals("loggedInUser")) {
					System.out.println(cookie.getValue());
					username = cookie.getValue();
					e = es.getEmployeeByUsername(username);
					s = es.getEmployeeById(e.getSupId());
					d = ds.getDeptById(e.getDeptId());
					
				} else if (cookie.getName().equals("subId")) {
					String input = cookie.getValue();
					int sid = Integer.parseInt(input);
					sub = es.getEmployeeById(sid);
					ev = evs.getEventsByEmpId(sid);
					forms = fs.getFormsByEmpId(sid);
				}
			}
			res.getWriter().append("{\"employee\": " + gson.toJson(e) + ", \"supervisor\": " + gson.toJson(s) + ", \"department\": " + gson.toJson(d) +
					", \"events\": " + gson.toJson(ev) + ", \"forms\": " + gson.toJson(forms) +", \"subordinate\": " + gson.toJson(sub) +"}");
		}
		
	}

	
	
}
