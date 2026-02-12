package com.capT.MTM_Mapping;

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
		
		Subject s1 =  new Subject(); s1.setId(1); s1.setName("Java"); 
		Subject s2 =  new Subject(); s2.setId(2); s2.setName("SQL");
		Subject s3 =  new Subject(); s3.setId(3); s3.setName("Adv. Java");
		
		Trainer t1 = new Trainer(); t1.setId(1); t1.setName("Anjan"); t1.setPhno(1234);
		Trainer t2 = new Trainer(); t2.setId(2); t1.setName("Anjali"); t1.setPhno(1234);
		Trainer t3 = new Trainer(); t3.setId(3); t1.setName("Dillip"); t1.setPhno(1234);

		s1.setTrainers(Arrays.asList(t1,t2));
		s2.setTrainers(Arrays.asList(t3,t2));
		s3.setTrainers(Arrays.asList(t1,t3));
		
		t1.setSubjects(Arrays.asList(s1,s3));
		t2.setSubjects(Arrays.asList(s1,s2));
		t3.setSubjects(Arrays.asList(s2,s3));

		
		et.begin();
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
	}
}
