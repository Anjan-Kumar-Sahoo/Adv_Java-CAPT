package com.capT.M_O_Mappping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Company c = new Company(1,"IBM","BBSR");
		
		Department d1 = new Department(10, 12, "Front-End", c);
		Department d2 = new Department(200,8, "Back-End", c);
		
		et.begin();
		em.persist(c);
		em.persist(d1);
		em.persist(d2);
		et.commit();
	}
	

	
}
