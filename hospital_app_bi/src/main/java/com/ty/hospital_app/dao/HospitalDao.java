package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Address;
import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.Hospital;
import com.ty.hospital_app.entity.Item;
import com.ty.hospital_app.entity.MedOrders;
import com.ty.hospital_app.entity.Person;

public class HospitalDao {

	// save hospital
	public Hospital saveHospital(Hospital hospital) {
		if(hospital != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(hospital);
			EntityFactoryDto.entityTransaction.commit();
		}
		return hospital;
	}
	
	// find hospital
	public Hospital findHospital(int hospitalId) {
		return EntityFactoryDto.entitManager.find(Hospital.class, hospitalId);
	}
	
	// update hospital
	public Hospital updateHospital(int hospitalId, Hospital hospital) {
		if(hospitalId == hospital.getHospital_Id() && hospital != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(hospital);
			EntityFactoryDto.entityTransaction.commit();
		}
		return hospital;
	}
	
	// remove hospital
	public boolean removeHospital(int hospitalId) {
		Hospital hospital = findHospital(hospitalId);
		if(hospital != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(hospital);
			EntityFactoryDto.entityTransaction.commit();
			System.out.println("Hospital removed");
			return true;
		}else {
			System.out.println("Hospital not found");
		}
		return false;
	}
	
	// remove hospital
//	public boolean removeHospital(String hospitalId) {
//		Hospital hospital = findHospital(hospitalId);
//		List<Branch> branches = hospital.getHospital_Branches();
//		for (Branch branch : branches) {
//			Address address = branch.getAddress();
//			List<Encounter> encounters = branch.getEncounters();
//			for (Encounter encounter : encounters) {
//				Person person = encounter.getPerson();
//				List<MedOrders> orders = encounter.getOrders();
//				for (MedOrders order : orders) {
//					List<Item> items = order.getItems();
//					for(Item item : items) {
//						EntityFactoryDto.entityTransaction.begin();;
//						EntityFactoryDto.entitManager.remove(item);
//						EntityFactoryDto.entityTransaction.commit();
//					}
//					order.setItems(null);
//					EntityFactoryDto.entityTransaction.begin();;
//					EntityFactoryDto.entitManager.remove(order);
//					
//					EntityFactoryDto.entityTransaction.commit();
//				}
//				
//			}
//		}
//		if(hospitalId != null) {
//			EntityFactoryDto.entityTransaction.begin();
//			EntityFactoryDto.entitManager.remove(hospital);
//			EntityFactoryDto.entityTransaction.commit();
//			return true;
//		}
//		return false;
//	}
}
