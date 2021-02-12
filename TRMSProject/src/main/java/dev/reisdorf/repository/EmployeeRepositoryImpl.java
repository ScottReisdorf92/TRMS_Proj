package dev.reisdorf.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.Employee;
import dev.reisdorf.util.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private static Connection conn = JDBCConnection.getConnection();
			
	@Override
	public Employee addEmployee(Employee emp) {
		try {
			String sql = "CALL add_emp(?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, emp.getUsername());
			cs.setString(2, emp.getPassword());
			cs.setString(3, emp.getFname());
			cs.setString(4, emp.getLname());
			cs.setString(5, emp.getEmail());
			cs.setString(6, Integer.toString(emp.getSupId()));
			cs.setString(7, Integer.toString(emp.getDeptId()));
			cs.setString(8, Double.toString(emp.getAvailAmt()));
			
			cs.executeQuery();
			
			sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, emp.getUsername());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emp.setEmpId(rs.getInt("EMP_ID"));
				return emp;
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setUsername(rs.getString("USERNAME"));
				emp.setPassword(rs.getString("EMP_PASS"));
				emp.setFname(rs.getString("F_NAME"));
				emp.setLname(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setSupId(rs.getInt("SUPER_ID"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setAvailAmt(rs.getInt("AVAIL_RMBT"));
				employees.add(emp);
			}
			return employees;
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setUsername(rs.getString("USERNAME"));
				emp.setPassword(rs.getString("EMP_PASS"));
				emp.setFname(rs.getString("F_NAME"));
				emp.setLname(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setSupId(rs.getInt("SUPER_ID"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setAvailAmt(rs.getInt("AVAIL_RMBT"));
				return emp;
			}
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setUsername(rs.getString("USERNAME"));
				emp.setPassword(rs.getString("EMP_PASS"));
				emp.setFname(rs.getString("F_NAME"));
				emp.setLname(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setSupId(rs.getInt("SUPER_ID"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setAvailAmt(rs.getInt("AVAIL_RMBT"));
				return emp;
			}
				
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return null;
	}
	
	@Override
	public List<Employee> getEmployeesBySupId(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE super_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setUsername(rs.getString("USERNAME"));
				emp.setPassword(rs.getString("EMP_PASS"));
				emp.setFname(rs.getString("F_NAME"));
				emp.setLname(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setSupId(rs.getInt("SUPER_ID"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setAvailAmt(rs.getInt("AVAIL_RMBT"));
				employees.add(emp);
			}
			return employees;
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySupUsername(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getEmployeesBySupId(rs.getInt("EMP_ID"));
					
			}
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Employee> getEmployeesByDeptId(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setUsername(rs.getString("USERNAME"));
				emp.setPassword(rs.getString("EMP_PASS"));
				emp.setFname(rs.getString("F_NAME"));
				emp.setLname(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setSupId(rs.getInt("SUPER_ID"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setAvailAmt(rs.getInt("AVAIL_RMBT"));
				employees.add(emp);
			}
			return employees;
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Employee> getEmployeesByDeptName(String name) {
		try {
			String sql = "SELECT * FROM departments WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getEmployeesByDeptId(rs.getInt("DEPT_ID"));
			}
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		try {
			String sql = "UPDATE employees SET username = ?, emp_pass = ?, f_name = ?, l_name = ?, email = ?, "
					+ "super_id = ?, dept_id = ?, avail_rmbt = ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFname());
			ps.setString(4, emp.getLname());
			ps.setString(5, emp.getEmail());
			ps.setString(6, Integer.toString(emp.getSupId()));
			ps.setString(7, Integer.toString(emp.getDeptId()));
			ps.setString(8, Double.toString(emp.getAvailAmt()));
			ps.setString(9, Integer.toString(emp.getEmpId()));
			
			ps.executeQuery();
									
			return emp;
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteEmpById(int id) {
		try {
			String sql = "DELETE FROM employees WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ps.executeQuery();
			return true;
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEmpByUsername(String username) {
		
		try {
			String sql = "DELETE FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ps.executeQuery();
			return true;
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	

	

}
