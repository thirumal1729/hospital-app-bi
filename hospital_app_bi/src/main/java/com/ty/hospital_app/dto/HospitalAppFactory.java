package com.ty.hospital_app.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dao.MedOrdersDao;
import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.entity.Address;
import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.Hospital;
import com.ty.hospital_app.entity.Item;
import com.ty.hospital_app.entity.MedOrders;
import com.ty.hospital_app.entity.Person;

public class HospitalAppFactory {
	private static Scanner scan = new Scanner(System.in);
	
	public static Hospital getHospitalObject() {
		Hospital hospital = new Hospital();
		System.out.print("Enter the hospital name : ");
		String hospitalName = scan.next();
		System.out.print("Enter the hospital specialization : ");
		String hospitalSpecialization = scan.next();
		System.out.print("Enter the hospital head office : ");
		String hospitalHeadOffice = scan.next();
		hospital.setHospital_Name(hospitalName);
		hospital.setHospital_Specialization(hospitalSpecialization);
		hospital.setHospital_head_office(hospitalHeadOffice);
		List<Branch> branches = new ArrayList<>();
		hospital.setHospital_Branches(branches);
		return hospital;
	}
	
	public static Branch getBranchObject() {
		Branch branch = new Branch();
		System.out.print("Enter the branch name : ");
		String branchName = scan.next();
		System.out.print("Enter the brach phone number : ");
		long branchPhoneNumber = scan.nextLong();
		System.out.print("Enter the branch email : ");
		String branchEmail = scan.next();
		System.out.print("Enter the branch specialization : ");
		String branchSpecialization = scan.next();
		System.out.print("Enter the number of doctors : ");
		int numberOfDoctors = scan.nextInt();
		
		Address address = getAddressObject();
		List<Encounter> encounters = new ArrayList<Encounter>();
		
		branch.setBranchName(branchName);
		branch.setBranchPhoneNumber(branchPhoneNumber);
		branch.setBranchEmail(branchEmail);
		branch.setBranchSpecialization(branchSpecialization);
		branch.setNumberOfDoctors(numberOfDoctors);
		branch.setAddress(address);
		branch.setEncounters(encounters);
		return branch;
	}
	
	public static Encounter getEncounterObject() {
		
		System.out.print("Enter the diagonosis : ");
		String diagonosis = scan.next();
		System.out.print("ChiefComplaint : ");
		String chiefComplaint = scan.next();
		System.out.print("ConsultantDepartmentName : ");
		String consultDepartmentName = scan.next();
		System.out.println("isSerious");
		boolean isSerious = scan.nextBoolean();
		Person person = new Person();
		List<MedOrders> medOrders = new ArrayList<MedOrders>();
		Encounter encounter = new Encounter();
		encounter.setDiagonosis(diagonosis);
		encounter.setChiefComplaint(chiefComplaint);
		encounter.setConsultDepartmentName(consultDepartmentName);
		encounter.setSerious(isSerious);
		encounter.setPerson(person);
		encounter.setOrders(medOrders);
		return encounter;
	}
	
	public static MedOrders getMedOrdersObject() {
		System.out.print("Enter prescribed doctor : ");
		String prescribedDoctor = scan.next();
		System.out.print("Enter order dosage : ");
		String orderDosage = scan.next();
		System.out.print("Enter order medication type: ");
		String orderMedicationType = scan.next();
		System.out.println("Enter isOrderCompleted");
		boolean isOrderCompleted = scan.nextBoolean();
		
		MedOrders medOrders = new MedOrders();
		List<Item> items = new ArrayList<>();
		System.out.print("Enter number of items : ");
		int noOfItems = scan.nextInt();
		for (int i = 0; i < noOfItems; i++) {
			items.add(getItemObject());
		}
		
		medOrders.setPrescribedDoctor(prescribedDoctor);
		medOrders.setOrderDosage(orderDosage);
		medOrders.setOrderMedicationType(orderMedicationType);
		medOrders.setItems(items);
		medOrders.setOrderCompleted(isOrderCompleted);
		return medOrders;
	}
	
	
	public static Item getItemObject() {
		System.out.print("Enter item name : ");
		String item_Name = scan.next();
		System.out.print("Enter item manufacturer : ");
		String item_Manufacturer = scan.next();
		System.out.print("Enter item cost: ");
		double item_Cost = scan.nextDouble();
		System.out.println("Enter item quantity");
		String item_quantity = scan.next();
		
		List<MedOrders> orders = new ArrayList<MedOrders>();
		
		Item item = new Item();
		item.setItem_Name(item_Name);
		item.setItem_Manufacturer(item_Manufacturer);
		item.setItem_Cost(item_Cost);
		item.setItem_quantity(item_quantity);
		item.setMedOrders(orders);
		
		return item;
	}
	
	public static Person getPersonObject() {
		System.out.print("Enter the person name : ");
		String person_Name = scan.next();
		System.out.print("Enter the person email : ");
		String person_email = scan.next();
		System.out.print("Enter the person phone number : ");
		long person_PhoneNumber = scan.nextLong();
		System.out.print("Enter the person age : ");
		int person_Age = scan.nextInt();
		System.out.print("Enter the person address : ");
		String person_Address = scan.next();
		System.out.print("Enter the person blood group : ");
		String person_BloodGroup = scan.next();
		
		List<Encounter> encounter = new ArrayList<Encounter>();
		
		Person person = new Person();
		person.setPerson_Name(person_Name);
		person.setPerson_email(person_email);
		person.setPerson_PhoneNumber(person_PhoneNumber);
		person.setPerson_Age(person_Age);
		person.setPerson_Address(person_Address);
		person.setPerson_BloodGroup(person_BloodGroup);
		person.setEncounters(encounter);
		
		return person;
	}
	
	public static Address getAddressObject() {
		System.out.print("Enter the street name : ");
		String streetName = scan.next();
		System.out.print("Enter the city name : ");
		String cityName = scan.next();
		System.out.print("Enter the district name : ");
		String districtName = scan.next();
		System.out.print("Enter the state name : ");
		String stateName = scan.next();
		System.out.print("Enter the postal id : ");
		int postalCode = scan.nextInt();
		
		Address address = new Address();
		address.setStreetName(streetName);
		address.setCityName(cityName);
		address.setDistrictName(districtName);
		address.setStateName(stateName);
		address.setPostalCode(postalCode);
		
		return address;
	}
	
	public static HospitalDao getHospitalDaoObject() {
		return new HospitalDao();
	}
	
	public static BranchDao getBranchDaoObject() {
		return new BranchDao();
	}
	
	public static EncounterDao getEncounterDaoObject() {
		return new EncounterDao();
	}
	
	public static PersonDao getPersonDaoObject() {
		return new PersonDao();
	}
	
	public static MedOrdersDao getMedOrdersDaoObject() {
		return new MedOrdersDao();
	}
	
	public static void printHospital(Hospital hospital) {
		System.out.println("Hospital id : "+hospital.getHospital_Id());
		System.out.println("Hospital name : "+hospital.getHospital_Name());
		System.out.println("Hospital specialization : "+hospital.getHospital_Specialization());
		System.out.println("Hospital head office : "+hospital.getHospital_head_office());
	}
	
	public static void printBranch(Branch branch) {
		System.out.println("Branch id : "+branch.getBranch_Id());
		System.out.println("Branch name : "+branch.getBranchName());
		System.out.println("Branch phone number : "+branch.getBranchPhoneNumber());
		System.out.println("Branch email id : "+branch.getBranchEmail());
		System.out.println("Branch specialization : "+branch.getBranchSpecialization());
		System.out.println("Number od doctors : "+branch.getNumberOfDoctors());
		Address address = branch.getAddress();
		System.out.println("-----------------Branch Adderss------------------");
		System.out.println("Street : "+address.getStreetName());
		System.out.println("City : "+address.getCityName());
		System.out.println("District : "+address.getDistrictName());
		System.out.println("State : "+address.getStateName());
		System.out.println("Postal code : "+address.getPostalCode());
	}
	
	public static void printPerson(Person person) {
		System.out.println("Person id : "+person.getPerson_Id());
		System.out.println("Person name : "+person.getPerson_Name());
		System.out.println("Person email : "+person.getPerson_email());
		System.out.println("Person phone number : "+person.getPerson_PhoneNumber());
		System.out.println("Person age : "+person.getPerson_Age());
		System.out.println("Person address : "+person.getPerson_Address());
		System.out.println("Person blood group : "+person.getPerson_BloodGroup());
	}
	
	public static void printEncounter(Encounter encounter) {
		System.out.println("Encounter id : "+encounter.getEncounter_Id());
		System.out.println("Diagnosis : "+encounter.getDiagonosis());
		System.out.println("Chief complaint : "+encounter.getChiefComplaint());
		System.out.println("Consult departpent name : "+encounter.getConsultDepartmentName());
	}
	
	public static void printMedOrders(MedOrders order) {
		System.out.println("Order id : "+order.getOrder_Id());
		System.out.println("Prescribed doctor : "+order.getPrescribedDoctor());
		System.out.println("Order dosage : "+order.getOrderDosage());
		System.out.println("Order medication type : "+order.getOrderMedicationType());
		if(order.isOrderCompleted()) {
			System.out.println("Order completed");
		} else {
			System.out.println("Order pending");
		}
		
		System.out.println("----------------------------Items-------------------------");
		List<Item> items = order.getItems();
		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item : "+(i+1));
			Item item = items.get(i);
			System.out.println("Item name : "+item.getItem_Name());
			System.out.println("Item Manufacturer : "+item.getItem_Manufacturer());
			System.out.println("Item name : "+item.getItem_Name());
			System.out.println("Item cost : "+item.getItem_Cost());
			System.out.println("Number of items : "+item.getItem_quantity());
		}
	}
	
	public static Hospital getUpdatedHospitalObject(int hospitalId) {
		
		Hospital hospital = getHospitalDaoObject().findHospital(hospitalId);
		if(hospital != null) {
			System.out.println("1. To update hospital name");
			System.out.println("2. To update hospital specialization");
			System.out.println("3. To update hospital head office");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("Enter the new name : ");
				String hospitalName = scan.next();
				hospital.setHospital_Name(hospitalName);
				break;
			}
			case 2: {
				System.out.print("Enter the new specialization : ");
				String hospitalSpecialization = scan.next();
				hospital.setHospital_Specialization(hospitalSpecialization);
				break;
			}
			case 3: {
				System.out.print("Enter the new head office : ");
				String hospitalHeadOffice = scan.next();
				hospital.setHospital_Name(hospitalHeadOffice);
				break;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
		
		return hospital;
	}
	
	public static Branch getUpdatedBranchObject(int branchId) {
		Branch branch = getBranchDaoObject().findBranch(branchId);
		if(branch != null) {
			System.out.println("1. To update branch name");
			System.out.println("2. To update branch phone number");
			System.out.println("3. To update branch email");
			System.out.println("4. To update hospital specialization");
			System.out.println("5. To update number of doctors");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("Enter the new name : ");
				String branchName = scan.next();
				branch.setBranchName(branchName);
				break;
			}
			case 2: {
				System.out.print("Enter the new phone number : ");
				int branchPhoneNumber = scan.nextInt();
				branch.setBranchPhoneNumber(branchPhoneNumber);
				break;
			}
			case 3: {
				System.out.print("Enter the new email : ");
				String branchEmail = scan.next();
				branch.setBranchEmail(branchEmail);
				break;
			}
			case 4: {
				System.out.print("Enter the new specialization : ");
				String branchSpecialization = scan.next();
				branch.setBranchSpecialization(branchSpecialization);
				break;
			}
			case 5: {
				System.out.print("Enter the new number of doctors : ");
				int noOfDoctors = scan.nextInt();
				branch.setNumberOfDoctors(noOfDoctors);
				break;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
		
		return branch;
	}
	
	public static Encounter getUpdatedEncounterObject(int encounterId) {
		Encounter encounter = getEncounterDaoObject().findEncounter(encounterId);
		if(encounter != null) {
			System.out.println("1. To update diagnosis");
			System.out.println("2. To update chief complaint");
			System.out.println("3. To update consult department name");
			System.out.println("4. To update seriousness");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("Enter the new diagnosis : ");
				String diagnosis = scan.next();
				encounter.setDiagonosis(diagnosis);
				break;
			}
			case 2: {
				System.out.print("Enter the new chief complaint : ");
				String chiefComplaint = scan.next();
				encounter.setChiefComplaint(chiefComplaint);
				break;
			}
			case 3: {
				System.out.print("Enter the new consult department name : ");
				String consultDepartmentName = scan.next();
				encounter.setConsultDepartmentName(consultDepartmentName);
				break;
			}
			case 4: {
				System.out.print("Enter the current seriousness : ");
				boolean isSerious = scan.nextBoolean();
				encounter.setSerious(isSerious);
				break;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
		return encounter;
	}
	
	public static MedOrders getUpdatedMedOrdersObject(int medOrderId) {
		MedOrders order = getMedOrdersDaoObject().findOrder(medOrderId);
		if(order != null) {
			System.out.println("1. To update prescribed doctor");
			System.out.println("2. To update order dosage");
			System.out.println("3. To update medication tpe");
			System.out.println("4. To update order status");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("Enter the new prescribed doctor : ");
				String prescribedDoctor = scan.next();
				order.setPrescribedDoctor(prescribedDoctor);
				break;
			}
			case 2: {
				System.out.print("Enter the new order dosage : ");
				String orderDosage = scan.next();
				order.setOrderDosage(orderDosage);
				break;
			}
			case 3: {
				System.out.print("Enter the new consult medication tpe : ");
				String medicationType = scan.next();
				order.setOrderMedicationType(medicationType);
				break;
			}
			case 4: {
				System.out.print("Enter the current order status : ");
				boolean isOrederCompleted = scan.nextBoolean();
				order.setOrderCompleted(isOrederCompleted);
				break;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
		return order;
	}
	
	public static Person getUpdatedPersonObject(int personId) {
		Person person = getPersonDaoObject().findPerson(personId);
		if(person != null) {
			System.out.println("1. To update person name");
			System.out.println("2. To update person email");
			System.out.println("3. To update person phone number");
			System.out.println("4. To update person age");
			System.out.println("5. To update person address");
			System.out.println("6. To update person blood group");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("Enter the new person name : ");
				String personName = scan.next();
				person.setPerson_Name(personName);
				break;
			}
			case 2: {
				System.out.print("Enter the new person email : ");
				String personEmail = scan.next();
				person.setPerson_email(personEmail);
				break;
			}
			case 3: {
				System.out.print("Enter the new person phone number : ");
				int personPhoneNumber = scan.nextInt();
				person.setPerson_PhoneNumber(personPhoneNumber);
				break;
			}
			case 4: {
				System.out.print("Enter the new person age : ");
				int age = scan.nextInt();
				person.setPerson_Age(age);
				break;
			}
			case 5: {
				System.out.print("Enter the new person address : ");
				String personAddress = scan.next();
				person.setPerson_Address(personAddress);
				break;
			}
			case 6: {
				System.out.print("Enter the new person blood group : ");
				String personBloodGroup = scan.next();
				person.setPerson_BloodGroup(personBloodGroup);
				break;
			}
			default: System.out.println("Enter the correct choice");
			}
		}
		return person;
	}
}
