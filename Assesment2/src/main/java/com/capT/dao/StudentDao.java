package com.capT.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.capT.entity.Student;

@Component
public class StudentDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public Student saveStudent(Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
		return s;
	}
	public Student findStudentbyID(int id)
	{
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class,id);
		em.close();
		return s;
	}
	public Student updateStudent(int studentId, String newEmail) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Student s = em.find(Student.class, studentId);
		if(s != null) {
			s.setEmail(newEmail);
			em.merge(s);
		}
		et.commit();
		em.close();
		return s;
	}
	public void deleteStudentbyID(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Student s = em.find(Student.class, id);
		if(s != null) {
			em.remove(s);
		}
		et.commit();
		em.close();
	}
}
