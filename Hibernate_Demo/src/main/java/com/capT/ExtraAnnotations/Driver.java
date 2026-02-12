package com.capT.ExtraAnnotations;

import jakarta.persistence.*;

public class Driver {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Book b = new Book();
		
		b.setName("Life is Tough! But it melts through LOVE");
		b.setAuthor("Anjan");
		
		et.begin();
		em.persist(b);
		et.commit();
		
	}
}
