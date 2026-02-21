package com.capT.L2;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student(3,"Sohel");
		
		et.begin();
		em.persist(s1);
		et.commit();
		
		Student sf1 = em.find(Student.class, 1);
		Student sf2 = em.find(Student.class, 1);
		
		EntityManager em2 = emf.createEntityManager();
		
		Student sf3 = em2.find(Student.class, 1);
		
		
	}
}
