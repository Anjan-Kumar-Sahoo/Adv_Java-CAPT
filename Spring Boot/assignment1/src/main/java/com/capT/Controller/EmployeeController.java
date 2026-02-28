package com.capT.Controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capT.Entity.Employee;
import com.capT.Service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {
		
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee e) {
		 return service.saveEmployee(e);
	}
	@GetMapping("/employees")
	public List<Employee> findAll() {
		 return service.findAll();
	}
	
	@GetMapping("/employee")
	public Employee findEmployee(@RequestParam int id) {
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
	@GetMapping("/employees/search2")
	public List<Employee> findByDepartmentName(@RequestParam String department) {
		 return service.findByDepartmentName(department);
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
