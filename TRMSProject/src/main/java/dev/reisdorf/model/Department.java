package dev.reisdorf.model;

public class Department {
	
	// INSTANCE VARIABLES
	private int deptId;
	private String name;
	private int deptHead;
	
	// CONSTRUCTORS //
	/* NO ARGS */
	public Department() {
		super();
	}

	/* ID-LESS */
	public Department(String name, int deptHead) {
		super();
		this.name = name;
		this.deptHead = deptHead;
	}
	
	/* FULL ARGS */
	public Department(int deptId, String name, int deptHead) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.deptHead = deptHead;
	}
	
	//----- GETTERS AND SETTERS -----//
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(int deptHead) {
		this.deptHead = deptHead;
	}
	
	
	@Override
	public String toString() {
		return "Deptartment [deptId=" + deptId + ", name=" + name + ", deptHead=" + deptHead + "]";
	}

}
