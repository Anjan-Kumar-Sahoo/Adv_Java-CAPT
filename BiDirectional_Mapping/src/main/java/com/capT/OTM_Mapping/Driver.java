package com.capT.OTM_Mapping;

import java.util.*;

import jakarta.persistence.*;

public class Driver {
	public static void main(String ...args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
//		Bank fb = em.find(Bank.class, 101);
//		System.out.println("Bank delete : ");
//		System.out.println("Id: "+fb.getId());
//		System.out.println("Name: "+fb.getName());
//		System.out.println("Location: "+fb.getLocation());
		
//		List<Account> accList = fb.getAccounts();
//		for(Account a : accList)
//		{
//			System.out.println("Acc Details: ");
//			System.out.println("Id:"+a.getId());
//			System.out.println("Name: "+a.getName());
//			System.out.println("Balance: "+a.getBalance());
//		}
		
		EntityTransaction et = em.getTransaction();
		
		Account a1 = new Account();
		a1.setId(101); a1.setName("Anjan"); a1.setBalance(10000.0);
		Account a2 = new Account();
		a2.setId(102); a2.setName("Anjali"); a2.setBalance(210000.0);
		List<Account> acc = new ArrayList<>();
		acc.add(a1);acc.add(a2);
		Bank b = new Bank();
		b.setId(1); b.setName("SBI"); b.setLocation("ROU"); b.setAccounts(acc);
		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(b);
		et.commit();	
	}
}
