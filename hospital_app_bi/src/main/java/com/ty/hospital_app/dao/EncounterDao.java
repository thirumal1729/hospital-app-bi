package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.Person;

public class EncounterDao {

	// save encounter
	public Encounter saveEncounter(Encounter encounter, int branchId, int personId) {
		Branch branch = EntityFactoryDto.entitManager.find(Branch.class, branchId);
		Person person = EntityFactoryDto.entitManager.find(Person.class, personId);
		if(encounter!=null && branch!=null && person!=null) {
			encounter.setPerson(person);
			List<Encounter> encounters = branch.getEncounters();
			List<Encounter> personEncounters = person.getEncounters();
			encounter.setBranch(branch);
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.persist(encounter);
			encounters.add(encounter);
			personEncounters.add(encounter);
			branch.setEncounters(encounters);
			person.setEncounters(personEncounters);
			EntityFactoryDto.entitManager.merge(branch);
			EntityFactoryDto.entitManager.merge(person);
			EntityFactoryDto.entityTransaction.commit();
		}
		return encounter;
	}
	
	// find encounter
	public Encounter findEncounter(int encounterId) {
		return EntityFactoryDto.entitManager.find(Encounter.class, encounterId);
	}
	
	// update encounter
	public Encounter updateEncounter(int encounterId, Encounter encounter) {
		if (encounterId == encounter.getEncounter_Id() && encounter != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(encounter);
			EntityFactoryDto.entityTransaction.commit();
		}
		return encounter;
	}

	// remove encounter
	public boolean removeEncounter(int encounterId) {

		Encounter encounter = findEncounter(encounterId);
		if (encounter != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(encounter);
			EntityFactoryDto.entityTransaction.commit();
			System.out.println("Encounter removed");
			return true;
		}
		return false;
	}
}
