package dev.reisdorf.model;

import java.time.LocalDate;

public class RForm {
	
	// INSTANCE VARIABLES
	private int formId;
	private int empId;
	private int eventId;
	private String desc;
	private int timeMissed;
	private boolean urgent;
	private String supAppr;
	private String dheadAppr;
	private String bencoAppr;
	private String subDate;
	private String grade;
	private String finAppr;
	
	
	// CONSTRUCTORS //
	/* NO ARGS */
	public RForm() {
		super();
	}

	/* ID_LESS */
	public RForm(int empId, int eventId, String desc, int timeMissed, boolean urgent, String supAppr,
			String dheadAppr, String bencoAppr, String subDate, String grade, String finAppr) {
		super();
		this.empId = empId;
		this.eventId = eventId;
		this.desc = desc;
		this.timeMissed = timeMissed;
		this.urgent = urgent;
		this.supAppr = supAppr;
		this.dheadAppr = dheadAppr;
		this.bencoAppr = bencoAppr;
		this.subDate = subDate;
		this.grade = grade;
		this.finAppr = finAppr;
	}
	
	// FULL ARGS //
	public RForm(int formId, int empId, int eventId, String desc, int timeMissed, boolean urgent, String supAppr,
			String dheadAppr, String bencoAppr, String subDate, String grade, String finAppr) {
		super();
		this.formId = formId;
		this.empId = empId;
		this.eventId = eventId;
		this.desc = desc;
		this.timeMissed = timeMissed;
		this.urgent = urgent;
		this.supAppr = supAppr;
		this.dheadAppr = dheadAppr;
		this.bencoAppr = bencoAppr;
		this.subDate = subDate;
		this.grade = grade;
		this.finAppr = finAppr;
	}

	

	//----- GETTERS AND SETTERS -----//
	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTimeMissed() {
		return timeMissed;
	}

	public void setTimeMissed(int timeMissed) {
		this.timeMissed = timeMissed;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public String getSupAppr() {
		return supAppr;
	}

	public void setSupAppr(String supAppr) {
		this.supAppr = supAppr;
	}

	public String getDheadAppr() {
		return dheadAppr;
	}

	public void setDheadAppr(String dheadAppr) {
		this.dheadAppr = dheadAppr;
	}

	public String getBencoAppr() {
		return bencoAppr;
	}

	public void setBencoAppr(String bencoAppr) {
		this.bencoAppr = bencoAppr;
	}

	public String getSubDate() {
		return subDate;
	}

	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getFinAppr() {
		return finAppr;
	}

	public void setFinAppr(String finAppr) {
		this.finAppr = finAppr;
	}

	
	
	@Override
	public String toString() {
		return "RForm [formId=" + formId + ", empId=" + empId + ", eventId=" + eventId + ", desc=" + desc
				+ ", timeMissed=" + timeMissed + ", urgent=" + urgent + ", supAppr=" + supAppr + ", dheadAppr="
				+ dheadAppr + ", bencoAppr=" + bencoAppr + ", subDate=" + subDate + ", grade=" + grade + ", finAppr=" + finAppr + "]";
	}
	
	
	



	
	
	
	
	
}
