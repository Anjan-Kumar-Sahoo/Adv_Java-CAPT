package com.capT.M_M_Mappping;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Trainer t1 = new Trainer(1,8144338402L,"Anjan");
		Trainer t2 = new Trainer(2,9437222387L,"Dillip");
		Trainer t3 = new Trainer(3,8249533566L,"Anjali");
		List<Trainer> trainer = Arrays.asList(t1,t2,t3);
		
		Subject s =  new Subject(1,"Java", trainer);
		
		et.begin();
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(s);
		et.commit();
	}
}
