package com.capT.Mapping2;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EngineCRUDimplementation implements EngineCRUD {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public void saveEngine(Engine e) {
		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("Engine Saved.");
	}

	@Override
	public void updateEngineCC(int id, int cc) {
		Engine e = em.find(Engine.class, id);
		if (e != null) {
			e.setCc(cc);
			et.begin();
			em.merge(e);
			et.commit();
			System.out.println("Engine CC Updated.");
		} else {
			System.out.println("Engine not found with ID: " + id);
		}
	}

	@Override
	public void deleteEngine(int id) {
		Engine e = em.find(Engine.class, id);
		if (e != null) {
			et.begin();
			em.remove(e);
			et.commit();
			System.out.println("Engine Deleted.");
		} else {
			System.out.println("Engine not found with ID: " + id);
		}
	}

	@Override
	public void fetchEngineById(int id) {
		Engine e = em.find(Engine.class, id);
		if (e != null) {
			System.out.println("Id: " + e.getId());
			System.out.println("CC: " + e.getCc());
		} else {
			System.out.println("Engine not found with ID: " + id);
		}
	}

	@Override
	public void fetchEngineByCC(int cc) {
		Query q = em.createQuery("select e from Engine e where e.cc = :cc");
		q.setParameter("cc", cc);
		List<Engine> engineList = q.getResultList();
		
		if (engineList.isEmpty()) {
			System.out.println("No engines found with CC: " + cc);
		} else {
			for (Engine e : engineList) {
				System.out.println("\nId: " + e.getId());
				System.out.println("CC: " + e.getCc());
			}
		}
	}

	@Override
	public void findAllEngines() {
		Query q = em.createQuery("select e from Engine e");
		List<Engine> engineList = q.getResultList();
		
		if (engineList.isEmpty()) {
			System.out.println("No engines found.");
		} else {
			for (Engine e : engineList) {
				System.out.println("\nId: " + e.getId());
				System.out.println("CC: " + e.getCc());
			}
		}
	}
}
