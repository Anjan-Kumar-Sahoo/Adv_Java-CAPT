package com.capT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capT.dao.DepartmentDao;
import com.capT.entity.Department;
import com.capT.entity.Student;

@Component
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public Department addDepartment(Department dept) {
		return departmentDao.addDepartment(dept);
	}

	public Department getDepartmentById(int deptId) {
		return departmentDao.findDepartmentbyID(deptId);
	}

	public void assignStudentToDepartment(int deptId, Student student) {
		departmentDao.assignStudentToDepartment(deptId, student);
	}

	public void viewStudentsByDepartment(int deptId) {
		Department dept = departmentDao.findDepartmentbyID(deptId);
		if(dept != null) {
			System.out.println("Students in " + dept.getName() + ":");
			List<Student> students = departmentDao.findStudentsByDepartmentId(deptId);
			for(Student s : students)
				System.out.println("  - " + s.getName() + " (" + s.getEmail() + ")");
		} else {
			System.out.println("Department does not exist");
		}
	}

	public void deleteDepartment(int deptId) {
		departmentDao.deleteDepartment(deptId);
	}
}
