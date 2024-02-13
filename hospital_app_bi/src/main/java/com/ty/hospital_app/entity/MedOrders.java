package com.ty.hospital_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class MedOrders {

	@Id
	@Column(insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq_gen")
	@SequenceGenerator(name = "orders_seq_gen", initialValue = 401, allocationSize = 1, sequenceName = "orders_seq")
	private int order_Id;
	private String prescribedDoctor;
	private String orderDosage;
	private String orderMedicationType;
	private boolean isOrderCompleted;
	
	@ManyToOne
	@JoinColumn
	private Encounter encounter;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(joinColumns = @JoinColumn , inverseJoinColumns = @JoinColumn)
	private List<Item> items;

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public String getPrescribedDoctor() {
		return prescribedDoctor;
	}

	public void setPrescribedDoctor(String prescribedDoctor) {
		this.prescribedDoctor = prescribedDoctor;
	}

	public String getOrderDosage() {
		return orderDosage;
	}

	public void setOrderDosage(String orderDosage) {
		this.orderDosage = orderDosage;
	}

	public String getOrderMedicationType() {
		return orderMedicationType;
	}

	public void setOrderMedicationType(String orderMedicationType) {
		this.orderMedicationType = orderMedicationType;
	}

	public boolean isOrderCompleted() {
		return isOrderCompleted;
	}

	public void setOrderCompleted(boolean isOrderCompleted) {
		this.isOrderCompleted = isOrderCompleted;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	
}
