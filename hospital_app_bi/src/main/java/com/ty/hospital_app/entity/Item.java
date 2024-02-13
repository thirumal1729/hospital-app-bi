package com.ty.hospital_app.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
	@SequenceGenerator(name = "item_seq_gen", initialValue = 501, allocationSize = 1, sequenceName = "item_seq")
	private int item_Id;
	private String item_Name;
	private String item_Manufacturer;
	private double item_Cost;
	private String item_quantity;
	
	@ManyToMany(mappedBy = "items")
	private List<MedOrders> medOrders;
	
	public int getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public String getItem_Manufacturer() {
		return item_Manufacturer;
	}
	public void setItem_Manufacturer(String item_Manufacturer) {
		this.item_Manufacturer = item_Manufacturer;
	}
	public double getItem_Cost() {
		return item_Cost;
	}
	public void setItem_Cost(double item_Cost) {
		this.item_Cost = item_Cost;
	}
	public String getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	@Override
	public int hashCode() {
		return Objects.hash(item_Cost, item_Manufacturer, item_Name, item_quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Double.doubleToLongBits(item_Cost) == Double.doubleToLongBits(other.item_Cost)
				&& Objects.equals(item_Manufacturer, other.item_Manufacturer)
				&& Objects.equals(item_Name, other.item_Name) && Objects.equals(item_quantity, other.item_quantity);
	}
	
	
}
