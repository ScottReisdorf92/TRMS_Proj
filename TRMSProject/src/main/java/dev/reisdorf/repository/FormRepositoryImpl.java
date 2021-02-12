package dev.reisdorf.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.RForm;
import dev.reisdorf.util.JDBCConnection;

public class FormRepositoryImpl implements FormRepository {

	private static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public RForm addRForm(RForm form) {
		try {
			//String sql = "{CALL INSERT INTO employee_events VALUES (event_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING form_id INTO ?}";
			CallableStatement cs = conn.prepareCall("{CALL INSERT INTO rmbt_forms VALUES (form_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING form_id INTO ?}");
			cs.setString(1, Integer.toString(form.getEmpId()));
			cs.setString(2, Integer.toString(form.getEventId()));
			cs.setString(3, form.getDesc());
			cs.setString(4, Integer.toString(form.getTimeMissed()));
			if (form.isUrgent()) {
				cs.setString(5, Integer.toString(1));
			} else {
				cs.setString(5, Integer.toString(0));
			}
			cs.setString(6, form.getSupAppr());
			cs.setString(7, form.getDheadAppr());
			cs.setString(8, form.getBencoAppr());
			cs.setString(9, form.getSubDate());
			cs.setString(10, form.getGrade());
			cs.setString(11, form.getFinAppr());
			cs.registerOutParameter(12, Types.INTEGER);
			
			int updateCount = cs.executeUpdate();
			
			if(updateCount > 0) {
				form.setFormId(cs.getInt(12));
				return form;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RForm> getAllForms() {
		try {
			String sql = "SELECT * FROM rmbt_forms";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<RForm> forms = new ArrayList<RForm>();
			while(rs.next()) {
				RForm f = new RForm();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setDesc(rs.getString("EVENT_DESCRIPTION"));
				f.setTimeMissed(rs.getInt("TIME_MISSED"));
				
				//Ternary to find boolean value in DB since oracle doesnt allow booleans
				boolean urgent = (rs.getInt("URGENT") == 1) ? true : false; 
				f.setUrgent(urgent);
				
				f.setSupAppr(rs.getString("SUPER_APPR"));
				f.setDheadAppr(rs.getString("DEPT_APPR"));
				f.setBencoAppr(rs.getString("BENCO_APPR"));
				f.setSubDate(rs.getString("SUBMIT_DATE"));
				f.setGrade(rs.getString("GRADE"));
				f.setFinAppr(rs.getString("FINAL_APPR"));
				forms.add(f);
			}
			return forms;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RForm> getFormsByEmpId(int id) {
		try {
			String sql = "SELECT * FROM rmbt_forms WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			List<RForm> forms = new ArrayList<RForm>();
			while(rs.next()) {
				RForm f = new RForm();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setDesc(rs.getString("EVENT_DESCRIPTION"));
				f.setTimeMissed(rs.getInt("TIME_MISSED"));
				
				//Ternarys to find boolean value in DB since oracle doesnt allow booleans
				boolean urgent = (rs.getInt("URGENT") == 1) ? true : false; 
				f.setUrgent(urgent);
				
				f.setSupAppr(rs.getString("SUPER_APPR"));
				f.setDheadAppr(rs.getString("DEPT_APPR"));
				f.setBencoAppr(rs.getString("BENCO_APPR"));
				f.setSubDate(rs.getString("SUBMIT_DATE"));
				f.setGrade(rs.getString("GRADE"));
				f.setFinAppr(rs.getString("FINAL_APPR"));
				forms.add(f);
			}
			return forms;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RForm> getFormsByEmpUsername(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return getFormsByEmpId(rs.getInt("EMP_ID"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RForm getRFormById(int id) {
		try {
			String sql = "SELECT * FROM rmbt_forms WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				RForm f = new RForm();
				f.setFormId(rs.getInt("FORM_ID"));
				f.setEmpId(rs.getInt("EMP_ID"));
				f.setEventId(rs.getInt("EVENT_ID"));
				f.setDesc(rs.getString("EVENT_DESCRIPTION"));
				f.setTimeMissed(rs.getInt("TIME_MISSED"));
				
				//Ternarys to find boolean value in DB since oracle doesnt allow booleans
				boolean urgent = (rs.getInt("URGENT") == 1) ? true : false; 
				f.setUrgent(urgent);
				
				f.setSupAppr(rs.getString("SUPER_APPR"));
				f.setDheadAppr(rs.getString("DEPT_APPR"));
				f.setBencoAppr(rs.getString("BENCO_APPR"));
				f.setSubDate(rs.getString("SUBMIT_DATE"));
				f.setGrade(rs.getString("GRADE"));
				f.setFinAppr(rs.getString("FINAL_APPR"));
				return f;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RForm updateForm(RForm form) {
		try {
			String sql = "UPDATE rmbt_forms SET emp_id = ?, event_id = ?, event_description = ?, "
					+ "time_missed = ?, urgent = ?, super_appr = ?, dept_appr = ?, benco_Appr = ?, submit_date = ?, grade = ?, final_appr = ? "
					+ "WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(form.getEmpId()));
			ps.setString(2, Integer.toString(form.getEventId()));
			ps.setString(3, form.getDesc());
			ps.setString(4, Integer.toString(form.getTimeMissed()));
			if (form.isUrgent()) {
				ps.setString(5, Integer.toString(1));
			} else {
				ps.setString(5, Integer.toString(0));
			}
			ps.setString(6, form.getSupAppr());
			ps.setString(7, form.getDheadAppr());
			ps.setString(8, form.getBencoAppr());
			ps.setString(9, form.getSubDate().toString());
			ps.setString(10, form.getGrade());
			ps.setString(11, form.getFinAppr());
			ps.setString(12, Integer.toString(form.getFormId()));
			
			ps.executeQuery();
			
			return form;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteFormById(int id) {
		try {
			String sql = "DELETE FROM rmbt_forms WHERE form_id = ?";
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
	public boolean deleteFormByEmpId(int formId, int empId) {
		try {
			String sql = "DELETE FROM rmbt_forms WHERE form_id = ? AND emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(formId));
			ps.setString(2, Integer.toString(empId));
			
			ps.executeQuery();
			return true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteFormByUsername(int formId, String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return deleteFormByEmpId(formId, rs.getInt("EMP_ID"));
			}
			return true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
