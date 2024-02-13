package com.ty.hospital_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Encounter {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encounter_seq_gen")
	@SequenceGenerator(name = "encounter_seq_gen", initialValue = 301, allocationSize = 1, sequenceName = "encounter_seq")
	private int Encounter_Id;
	private String diagonosis;
	private String chiefComplaint;
	private String consultDepartmentName;
	private boolean isSerious;
	
	@ManyToOne
	@JoinColumn
	private Branch branch;
	
	@ManyToOne
	@JoinColumn
	private Person person;
	
	@OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
	private List<MedOrders> medOrders;

	public int getEncounter_Id() {
		return Encounter_Id;
	}

	public void setEncounter_Id(int encounter_Id) {
		Encounter_Id = encounter_Id;
	}

	public String getDiagonosis() {
		return diagonosis;
	}

	public void setDiagonosis(String diagonosis) {
		this.diagonosis = diagonosis;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getConsultDepartmentName() {
		return consultDepartmentName;
	}

	public void setConsultDepartmentName(String consultDepartmentName) {
		this.consultDepartmentName = consultDepartmentName;
	}

	public boolean isSerious() {
		return isSerious;
	}

	public void setSerious(boolean isSerious) {
		this.isSerious = isSerious;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<MedOrders> getOrders() {
		return medOrders;
	}

	public void setOrders(List<MedOrders> orders) {
		this.medOrders = orders;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<MedOrders> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	
	
}
