package com.capT.service;

import java.util.List;

import com.capT.dao.StudentDao;
import com.capT.entity.Course;
import com.capT.entity.Student;

public class StudentService {
	private StudentDao dao = new StudentDao();
	
	public Student registerStudent(String name,int age,double marks)
	{
		if(age<16 ||  age>40)
			throw new IllegalArgumentException("Candidate must be (16-40 years old" );
		if(marks<0 || marks>100)
			throw new IllegalArgumentException("Invalid Marks : must be within (0-100) range");
		Student s = new Student(name,age,marks);
		return dao.saveStudent(s);
	}
	public Student getStudent(int id)
	{
		Student s = dao.findStudentbyID(id);
		if(s==null)
			throw new IllegalArgumentException("Student Not Found with Id: "+id);
		return s;
	}
	public void updateMarks(int id, double newMarks)
	{
		//Student s = getStudent(id);
		if(newMarks<0 || newMarks>100)
			throw new IllegalArgumentException("Invalid New Marks : must be within (0-100) range");
		dao.updateStudentMarks(id, newMarks);
	}
	public void deleteStudent(int id)
	{
		//Student s = getStudent(id);
		dao.deleteStudentbyID(id);
	}
	
//	public java.util.List<Student> getAllStudents() {
//		return dao.getAllStudents();
//	}
	
	public void assignCourseToStudent(int studentId, int courseId) {
		dao.giveCourseToStudent(studentId, courseId);
	}
	
	public List<Course> getStudentCourses(int studentId) {
		List<Course> courses = dao.getStudentCourses(studentId);
		if(courses == null)
			throw new IllegalArgumentException("Student not found with Id: " + studentId);
		return courses;
	}
}
