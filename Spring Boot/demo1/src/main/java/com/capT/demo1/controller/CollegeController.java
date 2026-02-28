package com.capT.demo1.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capT.demo1.Entity.College;
import com.capT.demo1.Entity.Student;
import com.capT.demo1.Servicee.CollegeService;


@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	@PostMapping("/college")
	public College save(@RequestBody College s)
	{
		
		return service.saveCollege(s);
	}
	
	@GetMapping("/college/{id}")
	public College fetchStudentById(@PathVariable int id)
	{
		return service.findStudentById(id);
	}
	
	@DeleteMapping("/college")
	public String deleteStudent(@RequestBody College s)
	{
		if(service.deleteCollege(s))
			return "Data Deleted";
		else
			return "Data Not Found to delete";
	}
	@DeleteMapping("/college/{id}")
	public String deleteCollege(@PathVariable int id)
	{
		if(service.deleteCollegeById(id))
			return "Data Deleted";
		else
			return "Data Not Found to delete";
	}
	@GetMapping("/college")
	public List<College> fetchStudents()
	{
		return service.findAllColleges();
	}
	@PostMapping("/colleges")
	public List<College> saveAllStudents(@RequestBody List<College> clg)
	{
		return service.saveAllColleges(clg);
	}
}
