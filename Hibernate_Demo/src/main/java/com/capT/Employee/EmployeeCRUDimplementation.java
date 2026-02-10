package com.capT.Employee;



import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeCRUDimplementation implements EmployeeCRUD{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	@Override
	public void saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("Employee Saved.");
		
	}

	@Override
	public void updateEmployeeName(int id, String name) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, id);
		e.setName(name);
		et.begin();
		em.merge(e);
		et.commit();
		System.out.println("Employee Updated.");
	}

	@Override
	public void updateEmployeePhone(int id, Long phno) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, id);
		e.setPhno(phno);
		et.begin();
		em.merge(e);
		et.commit();
		System.out.println("Employee Updated.");
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, id);
		
		et.begin();
		em.remove(e);
		et.commit();
		System.out.println("Employee Deleted.");
	}

	@Override
	public void fetchEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, id);
		
		System.out.println("Id : "+e.getSid());
		System.out.println("Name : "+e.getName());
		System.out.println("Ph No. :"+e.getPhno());
	}
}
