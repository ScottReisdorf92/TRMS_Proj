package dev.reisdorf.services;

import java.util.List;

import dev.reisdorf.model.RForm;
import dev.reisdorf.repository.FormRepository;
import dev.reisdorf.repository.FormRepositoryImpl;

public class FormServiceImpl implements FormService {
	
	private static FormRepository fr = new FormRepositoryImpl();
	@Override
	public List<RForm> getFormsByEmpId(int id) {
		return fr.getFormsByEmpId(id);
	}
	@Override
	public RForm getFormById(int id) {
		return fr.getRFormById(id);
	}
	@Override
	public boolean deleteForm(int id) {
		return fr.deleteFormById(id);
	}
	@Override
	public RForm updateForm(RForm form) {
		return fr.updateForm(form);
	}
	@Override
	public RForm addForm(RForm form) {
		return fr.addRForm(form);
	}

}
