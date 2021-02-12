package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.Grade;
import dev.reisdorf.repository.GradeRepository;
import dev.reisdorf.repository.GradeRepositoryImpl;

public class GradeServiceImpl implements GradeService {
	
	private static GradeRepository gr = new GradeRepositoryImpl();
			
	@Override
	public Grade getGradeByFormId(int id) {
		return gr.getGradeByFormId(id);
	}

	@Override
	public List<Grade> getAllEmpGradesById(int id) {
		return gr.getAllEmpGradesById(id);
	}
	
	

}
