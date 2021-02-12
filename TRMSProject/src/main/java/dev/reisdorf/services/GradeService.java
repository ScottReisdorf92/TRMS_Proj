package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.Grade;

public interface GradeService {
	
	public Grade getGradeByFormId(int id);
	
	public List<Grade> getAllEmpGradesById(int id);
}
