package com.ty.hospital_app.dao;

import java.util.List;

import javax.persistence.Query;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Item;

public class ItemDao {

	// save item
	public Item saveItem(Item item) {
		return item;
	}
	
	// find item
	public Item findItem(int itemId) {
		return EntityFactoryDto.entitManager.find(Item.class, itemId);
	}
	
	// update item
	public Item updatePerson(int itemId, Item item) {
		if(itemId == item.getItem_Id() && item != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(item);
			EntityFactoryDto.entityTransaction.commit();
		}
		return item;
	}
	
	// remove item
	public boolean removeItem(int itemId) {
		
		Item item = findItem(itemId);
		if(item != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(item);
			EntityFactoryDto.entityTransaction.commit();
			return true;
		}
		return false;
	}
}
