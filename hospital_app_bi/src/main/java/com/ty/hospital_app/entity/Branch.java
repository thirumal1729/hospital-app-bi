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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Branch {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq_gen")
	@SequenceGenerator(name = "branch_seq_gen", initialValue = 101, allocationSize = 1, sequenceName = "branch_seq")
	private int branch_Id;
	private String branchName;
	private long branchPhoneNumber;
	private String branchEmail;
	private String branchSpecialization;
	private int numberOfDoctors;
	
	@ManyToOne
	@JoinColumn
	private Hospital hospital;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Address address;
	
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
	private List<Encounter> encounters;

	public int getBranch_Id() {
		return branch_Id;
	}

	public void setBranch_Id(int branch_Id) {
		this.branch_Id = branch_Id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchPhoneNumber() {
		return branchPhoneNumber;
	}

	public void setBranchPhoneNumber(long branchPhoneNumber) {
		this.branchPhoneNumber = branchPhoneNumber;
	}

	public String getBranchEmail() {
		return branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	public String getBranchSpecialization() {
		return branchSpecialization;
	}

	public void setBranchSpecialization(String branchSpecialization) {
		this.branchSpecialization = branchSpecialization;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public int getNumberOfDoctors() {
		return numberOfDoctors;
	}

	public void setNumberOfDoctors(int numberOfDoctors) {
		this.numberOfDoctors = numberOfDoctors;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
}
