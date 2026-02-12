package com.capT.Mapping2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Engine e = new Engine();
//		e.setId(100);
//		e.setCc(1500);
//		
//		Car c = new Car();
//		c.setId(1);
//		c.setModel("Tesla Model S");
//		c.setBrand("Tesla");
//		c.setEngine(e);
//		
//		et.begin();
//		em.persist(c);
//		em.persist(e);
//		et.commit();
		
//		Trying to delete the engine
//		Car c = em.find(Car.class,1);
//		e = c.getEngine();
//		
//		
//		et.begin();
//		em.remove(e);
//		et.commit();
	}

}
