package com.ty.hospital_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
	@SequenceGenerator(name = "address_seq_gen", initialValue = 201, allocationSize = 1, sequenceName = "address_seq")
	private int address_Id;
	private String streetName;
	private String cityName;
	private String districtName;
	private String stateName;
	private int postalCode;
	
	@OneToOne(mappedBy = "address")
	private Branch branch;
	
	public int getAddress_Id() {
		return address_Id;
	}
	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
	
}
