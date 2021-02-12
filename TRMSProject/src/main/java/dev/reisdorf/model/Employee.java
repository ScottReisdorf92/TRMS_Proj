package dev.reisdorf.model;

public class Employee {

	// INSTANCE VARIABLES //
	private int empId;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private int supId;
	private int deptId;
	private double availAmt;
	
	
	
	// CONSTRUCTORS //
	/* NO ARGS */
	public Employee() {
		super();
	}

	/*  ID-LESS CONSTRUCTOR */
	public Employee(String username, String password, String fname, String lname, String email, int supId, int deptId,
			double availAmt) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.supId = supId;
		this.deptId = deptId;
		this.availAmt = availAmt;
	}

	/* FULL ARGS */
	public Employee(int empId, String username, String password, String fname, String lname, String email, int supId,
			int deptId, double availAmt) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.supId = supId;
		this.deptId = deptId;
		this.availAmt = availAmt;
	}

	//----- GETTERS AND SETTERS -----//
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public double getAvailAmt() {
		return availAmt;
	}

	public void setAvailAmt(double availAmt) {
		this.availAmt = availAmt;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", email=" + email + ", supId=" + supId + ", deptId=" + deptId + ", availAmt="
				+ availAmt + "]";
	}
	
	
	
}
