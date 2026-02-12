package com.capT.O_O_BDM;

import jakarta.persistence.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = new Person();
		p.setId(1);
		p.setName("Anjan");
		
		Adhar a = new Adhar();
		a.setId(10);
		a.setLocation("Odisha");
		
		a.setPerson(p);
		p.setAdhar(a);
		
		et.begin();
		em.persist(p);
		em.persist(a);
		et.commit();
	}

}