package dev.reisdorf.services;

import dev.reisdorf.model.Department;
import dev.reisdorf.repository.DeptRepository;
import dev.reisdorf.repository.DeptRepositoryImpl;

public class DeptServiceImpl implements DeptService {
	
	private static DeptRepository dr = new DeptRepositoryImpl();
	
	@Override
	public Department getDeptById(int id) {
		return dr.getDeptById(id);
	}

	@Override
	public boolean isDeptHead(int id) {
		Department dept = dr.getDeptByHeadId(id);
		if (dept != null) {
			return true;
		}
		return false;
	}

}
