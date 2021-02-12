package dev.reisdorf.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class EmpEvent {

	// INSTANCE VARIABLES //
	private int eventId;
	private int empId;
	private String eventType;
	private String passGrade;
	private String gradeFormat;
	private String startDate;
	private String startTime;
	private double cost;
	private String name;
	private String location;
	
	// CONSTRUCTORS //
	/* NO ARGS */
	public EmpEvent() {
		super();
	}
	
	/* ID_LESS */
	public EmpEvent(int empId, String eventType, String passGrade, String gradeFormat, String startDate, String startTime,
			double cost, String name, String location) {
		super();
		this.empId = empId;
		this.eventType = eventType;
		this.passGrade = passGrade;
		this.gradeFormat = gradeFormat;
		this.startDate = startDate;
		this.startTime = startTime;
		this.cost = cost;
		this.name = name;
		this.location = location;
	}

	/* FULL ARGS */
	public EmpEvent(int eventId, int empId, String eventType, String passGrade, String gradeFormat, String startDate,
			String startTime, double cost, String name, String location) {
		super();
		this.eventId = eventId;
		this.empId = empId;
		this.eventType = eventType;
		this.passGrade = passGrade;
		this.gradeFormat = gradeFormat;
		this.startDate = startDate;
		this.startTime = startTime;
		this.cost = cost;
		this.name = name;
		this.location = location;
	}

	//-----GETTERS AND SETTERS -----//
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getPassGrade() {
		return passGrade;
	}

	public void setPassGrade(String passGrade) {
		this.passGrade = passGrade;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "EmpEvent [eventId=" + eventId + ", empId=" + empId + ", eventType=" + eventType + ", passGrade="
				+ passGrade + ", gradeFormat=" + gradeFormat + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", cost=" + cost + ", name=" + name + ", location= " + location + "]";
	}

	
	
	
}
