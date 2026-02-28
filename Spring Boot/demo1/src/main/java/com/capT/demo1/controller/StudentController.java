package com.capT.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capT.demo1.Entity.Student;
import com.capT.demo1.Servicee.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	@PostMapping("/student")
	public Student save(@RequestBody Student s)
	{
		return service.saveStudent(s);
	}
	
	@GetMapping("/student/{id}")
	public Student fetchStudentById(@PathVariable int id)
	{
		return service.findStudentById(id);
	}
	
	@DeleteMapping("/student")
	public String deleteStudent(@RequestBody Student s)
	{
		if(service.deleteStudent(s))
			return "Data Deleted";
		else
			return "Data Not Found to delete";
	}
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		if(service.deleteStudentById(id))
			return "Data Deleted";
		else
			return "Data Not Found to delete";
	}
	@GetMapping("/student")
	public List<Student> fetchStudents()
	{
		return service.findAllStudents();
	}
	@PostMapping("/students")
	public List<Student> saveAllStudents(@RequestBody List<Student> stu)
	{
		return service.saveAllStudents(stu);
	}
}
