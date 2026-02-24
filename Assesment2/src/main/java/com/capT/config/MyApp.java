package com.capT.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capT.entity.Department;
import com.capT.entity.Student;
import com.capT.service.DepartmentService;
import com.capT.service.StudentService;

public class MyApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		DepartmentService deptService = context.getBean(DepartmentService.class);
		StudentService studentService = context.getBean(StudentService.class);
		
		System.out.println("=== 1. Adding Departments ===");
		Department cse = new Department();
		cse.setName("CSE");
		cse = deptService.addDepartment(cse);
		System.out.println("Department added: " + cse.getName());
		
		Department ece = new Department();
		ece.setName("ECE");
		ece = deptService.addDepartment(ece);
		System.out.println("Department added: " + ece.getName());
		
		System.out.println("=== 2. Adding Students ===");
		Student anjan = new Student();
		anjan.setName("Anjan");
		anjan.setEmail("anjan@cse.com");
		anjan = studentService.addStudent(anjan);
		System.out.println("Student added: " + anjan.getName());
		
		Student anjali = new Student();
		anjali.setName("Anjali");
		anjali.setEmail("anjali@cse.com");
		anjali = studentService.addStudent(anjali);
		System.out.println("Student added: " + anjali.getName());
		
		Student raju = new Student();
		raju.setName("Raju");
		raju.setEmail("raju@cse.com");
		raju = studentService.addStudent(raju);
		System.out.println("Student added: " + raju.getName());
		
		Student sohel = new Student();
		sohel.setName("Sohel");
		sohel.setEmail("sohel@ece.com");
		sohel = studentService.addStudent(sohel);
		System.out.println("Student added: " + sohel.getName());
		
		Student ravi = new Student();
		ravi.setName("Ravi");
		ravi.setEmail("ravi@ece.com");
		ravi = studentService.addStudent(ravi);
		System.out.println("Student added: " + ravi.getName());
		
		Student jotham = new Student();
		jotham.setName("Jotham");
		jotham.setEmail("jotham@ece.com");
		jotham = studentService.addStudent(jotham);
		System.out.println("Student added: " + jotham.getName());
		
		System.out.println("=== 3. Assigning Students to Departments ===");
		deptService.assignStudentToDepartment(cse.getId(), anjan);
		deptService.assignStudentToDepartment(cse.getId(), anjali);
		deptService.assignStudentToDepartment(cse.getId(), raju);
		deptService.assignStudentToDepartment(ece.getId(), sohel);
		deptService.assignStudentToDepartment(ece.getId(), ravi);
		deptService.assignStudentToDepartment(ece.getId(), jotham);
		
		System.out.println("=== 4. Get Department by ID (Using Cache) ===");
		Department foundDept = deptService.getDepartmentById(cse.getId());
		System.out.println("Found Department: " + foundDept.getName());
		
		System.out.println("=== 5. View Students by Department ===");
		deptService.viewStudentsByDepartment(cse.getId());
		deptService.viewStudentsByDepartment(ece.getId());
		
		System.out.println("=== 6. Update Student Email ===");
		Student updatedStudent = studentService.updateStudent(anjan.getId(), "anjan.updated@cse.com");
		System.out.println("Updated student: " + updatedStudent.getName() + " -> " + updatedStudent.getEmail());
		
		System.out.println("=== 7. Delete Student ===");
		studentService.deleteStudent(ravi.getId());
		System.out.println("Deleted student: " + ravi.getName());
		System.out.println("Remaining students in ECE:");
		deptService.viewStudentsByDepartment(ece.getId());
		
		System.out.println("=== 8. Delete Department (Cascade) ===");
		deptService.deleteDepartment(ece.getId());
		System.out.println("Deleted department: " + ece.getName());
		
		System.out.println("--- Application completed successfully ---");
	}
}
