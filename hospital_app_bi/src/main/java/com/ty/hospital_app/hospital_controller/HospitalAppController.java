package com.ty.hospital_app.hospital_controller;

import java.util.Scanner;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dao.MedOrdersDao;
import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.HospitalAppFactory;
import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.Hospital;
import com.ty.hospital_app.entity.MedOrders;
import com.ty.hospital_app.entity.Person;

public class HospitalAppController {
	
	private static HospitalDao hospitalDao = HospitalAppFactory.getHospitalDaoObject();
	private static BranchDao branchDao = HospitalAppFactory.getBranchDaoObject();
	private static PersonDao personDao = HospitalAppFactory.getPersonDaoObject();
	private static EncounterDao encounterDao = HospitalAppFactory.getEncounterDaoObject();
	private static MedOrdersDao medOrdersDao = HospitalAppFactory.getMedOrdersDaoObject();
	private static Scanner scan = new Scanner(System.in);
	
	private static int getChoice() {
		System.out.println("1. Save");
		System.out.println("2. Find");
		System.out.println("3. Update");
		System.out.println("4. Remove");
		System.out.println("5. Exit");
		System.out.print("Enter your choice : ");
		return scan.nextInt();
	}
	
	private static int getSaveChoice() {
		System.out.println("1. Save Hospital");
		System.out.println("2. Save Branch");
		System.out.println("3. Save Person");
		System.out.println("4. Save Encounter");
		System.out.println("5. Save MedOrders");
		System.out.print("Enter your choice : ");
		return scan.nextInt();
	}
	
	private static int getFindChoice() {
		System.out.println("1. Find Hospital");
		System.out.println("2. Find Branch");
		System.out.println("3. Find Person");
		System.out.println("4. Find Encounter");
		System.out.println("5. Find MedOrders");
		System.out.print("Enter your choice : ");
		return scan.nextInt();
	}
	
	private static int getUpdateChoice() {
		System.out.println("1. Update Hospital");
		System.out.println("2. Update Branch");
		System.out.println("3. Update Person");
		System.out.println("4. Update Encounter");
		System.out.println("5. Update MedOrders");
		System.out.print("Enter your choice : ");
		return scan.nextInt();
	}
	
	private static int getRemoveChoice() {
		System.out.println("1. Remove Hospital");
		System.out.println("2. Remove Branch");
		System.out.println("3. Remove Person");
		System.out.println("4. Remove Encounter");
		System.out.println("5. Remove MedOrders");
		System.out.print("Enter your choice : ");
		return scan.nextInt();
	}
	
	private static int getId(String str) {
		System.out.print("Enter the "+str+" ID :");
		return scan.nextInt();
	}
	
	public static void main(String[] args) {
		
		while(true) {
			switch(getChoice()) {
			case 1: {
				switch(getSaveChoice()) {
				case 1: {
					hospitalDao.saveHospital(HospitalAppFactory.getHospitalObject());
					break;
				}
				case 2: {
					branchDao.saveBranch(HospitalAppFactory.getBranchObject(), getId("hospital"));
					break;
				}
				case 3: {
					personDao.savePerson(HospitalAppFactory.getPersonObject());
					break;
				}
				case 4: {
					encounterDao.saveEncounter(HospitalAppFactory.getEncounterObject(), getId("branch"), getId("person"));
					break;
				}
				case 5: {
					medOrdersDao.saveMedOrders(HospitalAppFactory.getMedOrdersObject(), getId("encounter"));
					break;
				}
				default: System.out.println("Enter the correct choice");
				}
				break;
			}
			case 2: {
				switch(getFindChoice()) {
				case 1: {
					Hospital hospital = hospitalDao.findHospital(getId("hospital"));
					HospitalAppFactory.printHospital(hospital);
					break;
				}
				case 2: {
					Branch branch = branchDao.findBranch(getId("branch"));
					HospitalAppFactory.printBranch(branch);
					break;
				}
				case 3: {
					Person person = personDao.findPerson(getId("person"));
					HospitalAppFactory.printPerson(person);
					break;
				}
				case 4: {
					Encounter encounter = encounterDao.findEncounter(getId("encounter"));
					HospitalAppFactory.printEncounter(encounter);
					break;
				}
				case 5: {
					MedOrders orders = medOrdersDao.findOrder(getId("med orders"));
					HospitalAppFactory.printMedOrders(orders);
					break;
				}
				default: System.out.println("Enter the correct choice");
				}
				break;
			}
			case 3: {
				switch(getUpdateChoice()) {
				case 1: {
					int hospitalId = getId("hospital");
					hospitalDao.updateHospital(hospitalId, HospitalAppFactory.getUpdatedHospitalObject(hospitalId));
					break;
				}
				case 2: {
					int branchId = getId("branch");
					branchDao.updatePerson(branchId, HospitalAppFactory.getUpdatedBranchObject(branchId));
					break;
				}
				case 3: {
					int personId = getId("person");
					personDao.updatePerson(personId, HospitalAppFactory.getUpdatedPersonObject(personId));
					break;
				}
				case 4: {
					int encounterId = getId("encounter");
					encounterDao.updateEncounter(encounterId, HospitalAppFactory.getUpdatedEncounterObject(encounterId));
					break;
				}
				case 5: {
					int medOrderId = getId("medorder");
					medOrdersDao.updateEncounter(medOrderId, HospitalAppFactory.getUpdatedMedOrdersObject(medOrderId));
					break;
				}
				default: System.out.println("Enter the correct choice");
				}
				break;
			}
			case 4: {
				switch(getRemoveChoice()) {
				case 1: {
					hospitalDao.removeHospital(getId("hospital"));
					break;
				}
				case 2: {
					branchDao.removeBranch(getId("branch"));
					break;
				}
				case 3: {
					personDao.removePerson(getId("person"));
					break;
				}
				case 4: {
					encounterDao.removeEncounter(getId("encounter"));
					break;
				}
				case 5: {
					medOrdersDao.removeMedOrder(getId("med order"));
					break;
				}
				default: System.out.println("Enter the correct choice");
				}
				break;
			}
			case 5: {
				return;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
	}
}
