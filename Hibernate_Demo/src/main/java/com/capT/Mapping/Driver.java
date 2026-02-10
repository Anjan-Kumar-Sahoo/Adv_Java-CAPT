package com.capT.Mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Adhar a = new Adhar();
		a.setId(10);
		a.setLocation("INDIA");
		
		Person p = new Person();
		p.setId(1);
		p.setName("Anjan");
		p.setAdhar(a);
		
		et.begin();
		em.persist(p);
		em.persist(a);
		et.commit();
		
		// Trying to delet the aadhar
		// Person p = em.find(Person.class,1);
		// a = p.getAdhar();
		
		// et.begin();
		// em.remove(a);
		// et.commit();
	}

}