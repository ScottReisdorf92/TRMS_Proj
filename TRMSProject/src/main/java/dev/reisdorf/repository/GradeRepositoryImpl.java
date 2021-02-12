package dev.reisdorf.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.Grade;
import dev.reisdorf.util.JDBCConnection;

public class GradeRepositoryImpl implements GradeRepository {

	private static Connection conn = JDBCConnection.getConnection();
	@Override
	public Grade addGrade(Grade grade) {
		try {
			String sql = "INSERT INTO grades VALUES(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(grade.getEventId()));
			ps.setString(2, Integer.toString(grade.getEmpId()));
			ps.setString(3, Integer.toString(grade.getFormId()));
			ps.setString(4, grade.getGrade());
			
			ps.executeQuery();
			
			return grade;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grade> getAllGrades() {
		try {
			String sql = "SELECT * FROM grades";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<Grade> grades = new ArrayList<Grade>();
			while(rs.next()) {
				Grade g = new Grade();
				g.setEventId(rs.getInt("EVENT_ID"));
				g.setEmpId(rs.getInt("EMP_ID"));
				g.setFormId(rs.getInt("FORM_ID"));
				g.setGrade(rs.getString("GRADE"));
				grades.add(g);
			}
			return grades;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grade> getAllEmpGradesById(int id) {
		try {
			String sql = "SELECT * FROM grades WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			List<Grade> grades = new ArrayList<Grade>();
			while(rs.next()) {
				Grade g = new Grade();
				g.setEventId(rs.getInt("EVENT_ID"));
				g.setEmpId(rs.getInt("EMP_ID"));
				g.setFormId(rs.getInt("FORM_ID"));
				g.setGrade(rs.getString("GRADE"));
				grades.add(g);
			}
			return grades;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grade> getAllEmpGradesByUsername(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getAllEmpGradesById(rs.getInt("EMP_ID"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Grade getGradeByFormId(int id) {
		try {
			String sql = "SELECT * FROM grades WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Grade g = new Grade();
				g.setEventId(rs.getInt("EVENT_ID"));
				g.setEmpId(rs.getInt("EMP_ID"));
				g.setFormId(rs.getInt("FORM_ID"));
				g.setGrade(rs.getString("GRADE"));
				return g;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Grade getGradeByEventId(int id) {
		try {
			String sql = "SELECT * FROM grades WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Grade g = new Grade();
				g.setEventId(rs.getInt("EVENT_ID"));
				g.setEmpId(rs.getInt("EMP_ID"));
				g.setFormId(rs.getInt("FORM_ID"));
				g.setGrade(rs.getString("GRADE"));
				return g;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Grade updateGrade(Grade grade) {
		try {
			String sql = "UPDATE grades SET grade = ? WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, grade.getGrade());
			ps.setString(2, Integer.toString(grade.getEventId()));
			
			ps.executeQuery();
			
			return grade;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteGradeByFormId(int id) {
		try {
			String sql = "DELETE FROM grades WHERE form_id = ?";
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
	public boolean deleteGradeByEventId(int id) {
		try {
			String sql = "DELETE FROM grades WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(id));
			
			ps.executeQuery();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
