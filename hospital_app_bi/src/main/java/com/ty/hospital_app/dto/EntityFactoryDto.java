package com.ty.hospital_app.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityFactoryDto {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thirumal");
	public static EntityManager entitManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entitManager.getTransaction();
}
