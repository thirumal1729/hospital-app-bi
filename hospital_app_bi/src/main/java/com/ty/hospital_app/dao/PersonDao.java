package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Person;

public class PersonDao {
	
	public Person savePerson(Person person) {
		
		if(person != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.persist(person);
			EntityFactoryDto.entityTransaction.commit();
		}
		
		return person;
	}
	
	// find person
	public Person findPerson(int personId) {
		return EntityFactoryDto.entitManager.find(Person.class, personId);
	}
	
	// update person
	public Person updatePerson(int personId, Person person) {
		
		if(person != null) {
			if(personId == person.getPerson_Id()) {
				EntityFactoryDto.entityTransaction.begin();
				EntityFactoryDto.entitManager.merge(person);
				EntityFactoryDto.entityTransaction.commit();
			}
		}
		return person;
	}
	
	// remove person
	public boolean removePerson(int personId) {
		
		Person person = findPerson(personId);
		if(person != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(person);
			EntityFactoryDto.entityTransaction.commit();
			System.out.println("Person removed");
			return true;
		}
		return false;
	}
}
