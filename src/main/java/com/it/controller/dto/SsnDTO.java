package com.it.controller.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SsnDTO {

	private int sid;
	private String ssn;
	private String firstName;
	private String lastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dob;
	private String workAuth;
	private String notes;
	private Timestamp doe;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getWorkAuth() {
		return workAuth;
	}

	public void setWorkAuth(String workAuth) {
		this.workAuth = workAuth;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

}
