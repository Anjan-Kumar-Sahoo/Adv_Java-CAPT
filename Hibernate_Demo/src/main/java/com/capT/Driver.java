package com.capT;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public static EntityManager em = emf.createEntityManager();
	public static EntityTransaction et = em.getTransaction();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}