package com.campT.emplooyeeApp.Controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campT.emplooyeeApp.DTO.EmployeeDto;
import com.campT.emplooyeeApp.Entity.Employee;
import com.campT.emplooyeeApp.Service.EmployeeService;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {
		
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees")
	public EmployeeDto saveEmployee( @Valid @RequestBody Employee e) {
		 return service.saveEmployee(e);
	}
	@GetMapping("/employees")
	public List<Employee> findAll() {
		 return service.findAll();
	}
	
	@GetMapping("/employee")
	public Employee findEmployee( @Valid @RequestParam int id) {
		 return service.findById(id);
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam int id) {
		   service.deleteEmployeeById(id);
		    return "employee deleted";
	}
	
	@GetMapping("/employees/search1")
	public List<Employee> findByName(@RequestParam String name) {
		 return service.findByEmployeeName(name);
	}
	@GetMapping("/employees/search3")
	public List<Employee> findByPhone(@RequestParam long phone) {
		 return service.findByPhone(phone);
	}
	@GetMapping("/employees/search4")
	public List<Employee> findByEmail(@RequestParam String email) {
		 return service.findByEmailName(email);
	}
		
}

