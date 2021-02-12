package dev.reisdorf.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.Department;
import dev.reisdorf.util.JDBCConnection;

public class DeptRepositoryImpl implements DeptRepository {
	
	private static Connection conn = JDBCConnection.getConnection();
	
	
	@Override
	public Department addDept(Department dept) {
		try {
			String sql = "CALL add_dept(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, dept.getName());
			cs.setString(2, Integer.toString(dept.getDeptHead()));
			
			cs.executeQuery();
			sql = "SELECT * FROM departments WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dept.setDeptId(rs.getInt("DEPT_ID"));
				return dept;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Department> getAllDepts() {
		
		try {
			String sql = "SELECT * FROM departments";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Department> depts = new ArrayList<Department>();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("DEPT_ID"));
				dept.setName(rs.getString("DEPT_NAME"));
				dept.setDeptHead(rs.getInt("DEPT_HEAD"));
				depts.add(dept);
			}
			return depts;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Department getDeptById(int id) {
		try {
			String sql = "SELECT * FROM departments WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("DEPT_ID"));
				dept.setName(rs.getString("DEPT_NAME"));
				dept.setDeptHead(rs.getInt("DEPT_HEAD"));
				return dept;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Department getDeptByName(String name) {
		try {
			String sql = "SELECT * FROM departments WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("DEPT_ID"));
				dept.setName(rs.getString("DEPT_NAME"));
				dept.setDeptHead(rs.getInt("DEPT_HEAD"));
				return dept;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Department getDeptByHeadId(int id) {
		try {
			String sql = "SELECT * FROM departments WHERE dept_head = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("DEPT_ID"));
				dept.setName(rs.getString("DEPT_NAME"));
				dept.setDeptHead(rs.getInt("DEPT_HEAD"));
				return dept;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Department updateDept(Department dept) {
		try {
			String sql = "UPDATE departments SET dept_name = ?, dept_head = ? WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, dept.getName());
			ps.setString(2, Integer.toString(dept.getDeptHead()));
			ps.setString(3, Integer.toString(dept.getDeptId()));
			
			ps.executeQuery();			
			return dept;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delDeptById(int id) {
		try {
			String sql = "DELETE FROM departments WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, Integer.toString(id));
			
			ps.executeQuery();			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delDeptByName(String deptName) {
		try {
			String sql = "DELETE FROM departments WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, deptName);
			
			ps.executeQuery();			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	

}
