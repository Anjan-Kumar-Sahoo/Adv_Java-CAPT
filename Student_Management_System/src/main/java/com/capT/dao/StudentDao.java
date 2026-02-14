package com.capT.dao;

import java.util.List;

import com.capT.entity.Course;
import com.capT.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
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
	public void updateStudentMarks(int id,double newMarks)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = findStudentbyID(id);
		et.begin();
		if(s!=null)
		{
			s.setMarks(newMarks);
			em.merge(s);
		}
		et.commit();
		em.close();
	}
	public void deleteStudentbyID(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class,id);
		et.begin();
		if(s!=null)
			em.remove(s);
		et.commit();
		em.close();
	}
	
//	public List<Student> getAllStudents() {
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("SELECT s FROM Student s");
//		List<Student> students = query.getResultList();
//		em.close();
//		return students;
//	}
	
	public void giveCourseToStudent(int studentId, int courseId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);
		
		if(student != null && course != null) {
			student.giveCourseToStudent(course);
			course.getStudents().add(student);
			em.merge(student);
		}
		
		et.commit();
		em.close();
	}
	
	public List<Course> getStudentCourses(int studentId) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, studentId);
		List<Course> courses = null;
		if(student != null) {
			courses = student.getCourses();
		}
		em.close();
		return courses;
	}
}
