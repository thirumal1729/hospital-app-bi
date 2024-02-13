package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Address;

public class AddressDao {

	// save address
	public Address saveAddress(Address address) {
		return address;
	}
	
	// find address
	public Address findAddress(int addressId) {
		return EntityFactoryDto.entitManager.find(Address.class, addressId);
	}
	
	// update person
	public Address updateAddress(int personId, Address address) {
		if(personId == address.getAddress_Id() && address != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(address);
			EntityFactoryDto.entityTransaction.commit();
		}
		return address;
	}
	
	// remove person
	public boolean removeAddress(int addressId) {
		
		if(addressId != 0) {
			Address item = findAddress(addressId);
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(item);
			EntityFactoryDto.entityTransaction.commit();
			return true;
		}
		return false;
	}
}
