package com.capT.dao;

import java.util.List;

import com.capT.entity.Course;
import com.capT.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CourseDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public Course saveCourse(Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(course);
		et.commit();
		em.close();
		return course;
	}
	
	public Course findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		Course course = em.find(Course.class, id);
		em.close();
		return course;
	}
	
	public void updateCourseTrainer(int id, String newTrainer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Course course = findCourseById(id);
		et.begin();
		if(course != null) {
			course.setTrainer(newTrainer);
			em.merge(course);
		}
		et.commit();
		em.close();
	}
	
	public void deleteCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Course course = em.find(Course.class, id);
		et.begin();
		if(course != null)
			em.remove(course);
		et.commit();
		em.close();
	}
	
	public void enrollStudentInCourse(int studentId, int courseId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);
		
		if(student != null && course != null) {
			student.getCourses().add(course);
			course.getStudents().add(student);
			em.merge(student);
		}
		
		et.commit();
		em.close();
	}
	
	public List<Student> getStudentsInCourse(int courseId) {
		EntityManager em = emf.createEntityManager();
		Course course = em.find(Course.class, courseId);
		List<Student> students = null;
		if(course != null)
			students = course.getStudents();
		em.close();
		return students;
	}
//	public List<Course> getAllCourses() {
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("SELECT c FROM Course c");
//		List<Course> courses = query.getResultList();
//		em.close();
//		return courses;
//	}s
}
