package com.capT.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.capT.entity.Department;
import com.capT.entity.Student;

import java.util.List;

@Component
public class DepartmentDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public Department addDepartment(Department d) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
		em.close();
		return d;
	}
	
	public Department findDepartmentbyID(int id) {
		EntityManager em = emf.createEntityManager();
		Department d = em.find(Department.class, id);
		em.close();
		return d;
	}
	
	public List<Student> findStudentsByDepartmentId(int deptId) {
		EntityManager em = emf.createEntityManager();
		List<Student> students = em.createQuery(
			"SELECT s FROM Student s WHERE s.department.id = :deptId", Student.class)
			.setParameter("deptId", deptId)
			.getResultList();
		em.close();
		return students;
	}
	
	public void assignStudentToDepartment(int deptId, Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Department dept = em.find(Department.class, deptId);
		if(dept != null) {
			student.setDepartment(dept);
			em.merge(student);
		}
		et.commit();
		em.close();
	}
	
	public void deleteDepartment(int deptId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Department dept = em.find(Department.class, deptId);
		if(dept != null) {
			em.remove(dept);
		}
		et.commit();
		em.close();
	}

}
