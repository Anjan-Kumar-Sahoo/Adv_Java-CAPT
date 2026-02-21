package com.capT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capT.dao.StudentDao;
import com.capT.entity.Student;

@Component
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public Student addStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student getStudentById(int studentId) {
		return studentDao.findStudentbyID(studentId);
	}

	public Student updateStudent(int studentId, String newEmail) {
		return studentDao.updateStudent(studentId, newEmail);
	}

	public void deleteStudent(int studentId) {
		studentDao.deleteStudentbyID(studentId);
	}
}
