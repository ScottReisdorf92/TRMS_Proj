package dev.reisdorf.model;

public class Grade {
	
	// INSTANCE VARIABLES //
	private int eventId;
	private int empId;
	private int formId;
	private String grade;
	
	// CONSTRUCTOR //
	public Grade() {
		super();
	}

	public Grade(int eventId, int empId, int formId, String grade) {
		super();
		this.eventId = eventId;
		this.empId = empId;
		this.formId = formId;
		this.grade = grade;
	}

	//----- GETTERS AND SETTERS -----//
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "grades [eventId=" + eventId + ", empId=" + empId + ", formId=" + formId + ", grade=" + grade + "]";
	}
	
	
}
