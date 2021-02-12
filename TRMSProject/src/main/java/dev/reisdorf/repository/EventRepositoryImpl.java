package dev.reisdorf.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.EmpEvent;
import dev.reisdorf.util.JDBCConnection;

public class EventRepositoryImpl implements EventRepository {

	private static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public EmpEvent addEvent(EmpEvent event) {
		
		try {
			
			//String sql = "CALL add_event(?, ?, ?, ?, ?, ?, ?)";
			// 
			CallableStatement cs = conn.prepareCall("{CALL INSERT INTO employee_events VALUES (event_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING event_id INTO ?}");
			
			
			cs.setString(1, Integer.toString(event.getEmpId()));
			cs.setString(2, event.getEventType());
			cs.setString(3, event.getPassGrade());
			cs.setString(4, event.getStartDate().toString());
			cs.setString(5, event.getStartTime());
			cs.setString(6, Double.toString(event.getCost()));
			cs.setString(7, event.getGradeFormat());
			cs.setString(8, event.getName());
			cs.setString(9, event.getLocation());
			cs.registerOutParameter(10, Types.INTEGER);
			
			int updateCount = cs.executeUpdate();
			
			if(updateCount > 0) {
				event.setEventId(cs.getInt(10));
				return event;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<EmpEvent> getAllEvents() {
		try {
			
			String sql = "SELECT * FROM employee_events";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<EmpEvent> events = new ArrayList<EmpEvent>();
			while(rs.next()) {
				EmpEvent event = new EmpEvent();
				event.setEventId(rs.getInt("EVENT_ID"));
				event.setEmpId(rs.getInt("EMP_ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setPassGrade(rs.getString("PASS_GRADE"));
				event.setStartDate(rs.getString("START_DATE"));
				event.setStartTime((rs.getString("START_TIME")));
				event.setCost(rs.getDouble("EVENT_COST"));
				event.setGradeFormat(rs.getString("GRADE_FORMAT"));
				event.setName(rs.getString("EVENT_NAME"));
				event.setLocation(rs.getString("EVENT_LOCATION"));
				events.add(event);
			}
			return events;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<EmpEvent> getEventsByEmpId(int id) {
		try {
		
			String sql = "SELECT * FROM employee_events WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			List<EmpEvent> events = new ArrayList<EmpEvent>();
			while(rs.next()) {
				EmpEvent event = new EmpEvent();
				event.setEventId(rs.getInt("EVENT_ID"));
				event.setEmpId(rs.getInt("EMP_ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setPassGrade(rs.getString("PASS_GRADE"));
				event.setStartDate(rs.getString("START_DATE"));
				event.setStartTime((rs.getString("START_TIME")));
				event.setCost(rs.getDouble("EVENT_COST"));
				event.setGradeFormat(rs.getString("GRADE_FORMAT"));
				event.setName(rs.getString("EVENT_NAME"));
				event.setLocation(rs.getString("EVENT_LOCATION"));
				events.add(event);
			}
			return events;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<EmpEvent> getEventsByEmpUsername(String username) {
		try {
			
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return getEventsByEmpId(rs.getInt("EMP_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public EmpEvent getEventById(int id) {
		try {
			
			String sql = "SELECT * FROM employee_events WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				EmpEvent event = new EmpEvent();
				event.setEventId(rs.getInt("EVENT_ID"));
				event.setEmpId(rs.getInt("EMP_ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setPassGrade(rs.getString("PASS_GRADE"));
				event.setStartDate(rs.getString("START_DATE"));
				event.setStartTime((rs.getString("START_TIME")));
				event.setCost(rs.getDouble("EVENT_COST"));
				event.setGradeFormat(rs.getString("GRADE_FORMAT"));
				event.setName(rs.getString("EVENT_NAME"));
				event.setLocation(rs.getString("EVENT_LOCATION"));
				return event;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public EmpEvent updateEvent(EmpEvent event) {
		try {
			
			String sql = "UPDATE employee_events SET emp_id = ?, event_type = ?, pass_grade = ?, start_date = ?, start_time = ?, event_cost = ?, grade_format = ?, event_name = ?, event_location = ? WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(event.getEmpId()));
			ps.setString(2, event.getEventType());
			ps.setString(3, event.getPassGrade());
			ps.setString(4, event.getStartDate());
			ps.setString(5, event.getStartTime());
			ps.setString(6, Double.toString(event.getCost()));
			ps.setString(7, event.getGradeFormat());
			ps.setString(8, event.getName());
			ps.setString(9, event.getLocation());
			ps.setString(10, Integer.toString(event.getEventId()));
			
			ps.executeQuery();
			
			return event;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteEventById(int id) {
		try {
			
			String sql = "DELETE FROM employee_events WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(id));
		
			
			ps.executeQuery();
			
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEventByEmpId(int eventId, int empId) {
		try {
			
			String sql = "DELETE FROM employee_events WHERE event_id = ? AND emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(eventId));
			ps.setString(2, Integer.toString(empId));

			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteEventByUsername(int id, String username) {
		
		try {
			
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return deleteEventByEmpId(id, rs.getInt("EMP_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
