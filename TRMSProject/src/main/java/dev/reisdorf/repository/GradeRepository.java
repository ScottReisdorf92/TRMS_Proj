package dev.reisdorf.repository;

import java.util.List;

import dev.reisdorf.model.Grade;

public interface GradeRepository {

	// Create
	public Grade addGrade(Grade grade);
	
	// Read
	public List<Grade> getAllGrades();
	
	public List<Grade> getAllEmpGradesById(int id);
	
	public List<Grade> getAllEmpGradesByUsername(String username);
	
	public Grade getGradeByFormId(int id);
	
	public Grade getGradeByEventId(int id);
	
	// Update
	public Grade updateGrade(Grade grade);
	
	// Delete
	public boolean deleteGradeByFormId(int id);
	
	public boolean deleteGradeByEventId(int id);
	
	// delete by emp id and event name?
}
