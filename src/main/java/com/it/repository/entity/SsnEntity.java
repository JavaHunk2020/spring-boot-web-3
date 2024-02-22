package com.it.repository.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "social_security_number")
public class SsnEntity {
	private int sid;
	private String ssn;
	private String firstName;
	private String lastName;
	private Date dob;
	private String workAuth;
	private String notes;
	private Timestamp doe;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(unique = true,length = 11)
	public String getSsn() {
		return this.ssn;
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
