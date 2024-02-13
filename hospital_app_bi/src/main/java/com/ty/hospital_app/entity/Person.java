package com.ty.hospital_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
	@SequenceGenerator(name = "person_seq_gen", initialValue = 601, allocationSize = 1, sequenceName = "person_seq")
	private int person_Id;
	private String person_Name;
	private String person_email;
	private long person_PhoneNumber;
	private int person_Age;
	private String person_Address;
	private String person_BloodGroup;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
	private List<Encounter> encounters;
	
	public int getPerson_Id() {
		return person_Id;
	}
	public void setPerson_Id(int person_Id) {
		this.person_Id = person_Id;
	}
	public String getPerson_Name() {
		return person_Name;
	}
	public void setPerson_Name(String person_Name) {
		this.person_Name = person_Name;
	}
	public String getPerson_email() {
		return person_email;
	}
	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}
	public long getPerson_PhoneNumber() {
		return person_PhoneNumber;
	}
	public void setPerson_PhoneNumber(long person_PhoneNumber) {
		this.person_PhoneNumber = person_PhoneNumber;
	}
	public int getPerson_Age() {
		return person_Age;
	}
	public void setPerson_Age(int person_Age) {
		this.person_Age = person_Age;
	}
	public String getPerson_Address() {
		return person_Address;
	}
	public void setPerson_Address(String person_Address) {
		this.person_Address = person_Address;
	}
	public String getPerson_BloodGroup() {
		return person_BloodGroup;
	}
	public void setPerson_BloodGroup(String person_BloodGroup) {
		this.person_BloodGroup = person_BloodGroup;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	
}
