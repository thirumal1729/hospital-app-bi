package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.EntityFactoryDto;
import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.Item;
import com.ty.hospital_app.entity.MedOrders;

public class MedOrdersDao {

	// save med orders
	public MedOrders saveMedOrders(MedOrders orders, int encounterId) {
		Encounter encounter = EntityFactoryDto.entitManager.find(Encounter.class, encounterId);
		if(orders != null && encounter != null) {
			List<MedOrders> medOrders = encounter.getMedOrders();
			 
			medOrders.add(orders);
			encounter.setMedOrders(medOrders);
			ItemDao itemDao = new ItemDao();
			List<Item> items = orders.getItems();
			for (Item item : items) {
				List<MedOrders> itemOrders = item.getMedOrders();
				item.setMedOrders(itemOrders);
				itemDao.saveItem(item);
			}
			System.out.println("Items saved");
			orders.setEncounter(encounter);
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(encounter);
//			EntityFactoryDto.entitManager.persist(orders);
			EntityFactoryDto.entityTransaction.commit();
		}
		return orders;
	}
	
	// find med order
	public MedOrders findOrder(int orderId) {
		return EntityFactoryDto.entitManager.find(MedOrders.class, orderId);
	}
	
	// update med order
	public MedOrders updateEncounter(int orderId, MedOrders order) {
		if (orderId == order.getOrder_Id() && order != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.merge(order);
			EntityFactoryDto.entityTransaction.commit();
		}
		return order;
	}
	
	// remove med order
	public boolean removeMedOrder(int orderId) {

		MedOrders order = findOrder(orderId);
		if (order != null) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entitManager.remove(order);
			EntityFactoryDto.entityTransaction.commit();
			System.out.println("MedOrders removed");
			return true;
		}
		return false;
	}
}
