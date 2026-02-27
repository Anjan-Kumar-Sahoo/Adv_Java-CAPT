package com.capT;

import java.util.*;
import jakarta.persistence.*;

public class EmployeeDAO {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void saveEmployee(Employee e)
	{
		try {
			et.begin();
			em.persist(e);
			et.commit();
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
	public void deleteEmployee(int id)
	{
		try
		{
			Employee e = em.find(Employee.class, id);
			et.begin();
			em.remove(e);
			et.commit();
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
	public void updateEmployee(int id, Employee updatedEmployee)
	{
		try
		{
			Employee e = em.find(Employee.class, id);
			if(e != null)
			{
				et.begin();
				e.setName(updatedEmployee.getName());
				e.setDepartment(updatedEmployee.getDepartment());
				e.setSalary(updatedEmployee.getSalary());
				e.setPhone(updatedEmployee.getPhone());
				e.setEmail(updatedEmployee.getEmail());
				em.merge(e);
				et.commit();
			}
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
	
	public Employee getEmployeeById(int id)
	{
		try
		{
			return em.find(Employee.class, id);
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
			return null;
		}
	}
	
	public List<Employee> getAllEmployees()
	{
		try
		{
			return em.createQuery("FROM Employee", Employee.class).getResultList();
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
			return new ArrayList<>();
		}
	}
}

