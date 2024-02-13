package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Hospital;

public class BranchDao {

	// save branch
	public Branch saveBranch(Branch branch, int hospitalId) {
		if(EntityFactoryDto.entitManager.find(Hospital.class, hospitalId) != null && branch != null) {
			Hospital hospital = EntityFactoryDto.entitManager.find(Hospital.class, hospitalId);
			List<Branch> branches = hospital.getHospital_Branches();
			AddressDao addressDao = new AddressDao();
			addressDao.saveAddress(branch.getAddress());
			branch.setHospital(hospital);
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.persist(branch);
			branches.add(branch);
			hospital.setHospital_Branches(branches);
			EntityFactoryDto.entitManager.merge(hospital);
			EntityFactoryDto.entityTransaction.commit();

		}
		
		return branch;
	}
	
	// find branch
	public Branch findBranch(int branchId) {
		return EntityFactoryDto.entitManager.find(Branch.class, branchId);
	}

	// update branch
	public Branch updatePerson(int branchId, Branch branch) {
		if (branchId == branch.getBranch_Id() && branch != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(branch);
			EntityFactoryDto.entityTransaction.commit();
		}
		return branch;
	}

	// remove person
	public boolean removeBranch(int branchId) {
		
		Branch branch = findBranch(branchId);
		if (branch != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(branch);
			EntityFactoryDto.entityTransaction.commit();
			System.out.println("Branch removed");
			return true;
		}
		return false;
	}
}
