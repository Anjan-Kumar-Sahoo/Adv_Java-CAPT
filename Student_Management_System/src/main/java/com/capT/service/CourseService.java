package com.capT.service;

import java.util.List;

import com.capT.dao.CourseDao;
import com.capT.entity.Course;
import com.capT.entity.Student;

public class CourseService {
	private CourseDao dao = new CourseDao();
	
	public Course registerCourse(String name, String trainer) {
		if(name == null)
			throw new IllegalArgumentException("Course name cannot be empty");
		if(trainer == null )
			throw new IllegalArgumentException("Trainer name cannot be empty");
		
		Course course = new Course(name, trainer);
		return dao.saveCourse(course);
	}
	
	public Course getCourse(int id) {
		Course course = dao.findCourseById(id);
		if(course == null)
			throw new IllegalArgumentException("Course not found with Id: " + id);
		return course;
	}
	
	public void updateTrainer(int id, String newTrainer) {
		if(newTrainer == null || newTrainer.trim().isEmpty())
			throw new IllegalArgumentException("Trainer name cannot be empty");
		dao.updateCourseTrainer(id, newTrainer);
	}
	
	public void deleteCourse(int id) {
		dao.deleteCourseById(id);
	}
	
	public void enrollStudent(int studentId, int courseId) {
		dao.enrollStudentInCourse(studentId, courseId);
	}
	
//	public List<Course> getAllCourses() {
//		return dao.getAllCourses();
//	}
	
	public List<Student> getStudentsEnrolled(int courseId) {
		List<Student> students = dao.getStudentsInCourse(courseId);
		if(students == null)
			throw new IllegalArgumentException("Course not found with Id: " + courseId);
		return students;
	}
}
