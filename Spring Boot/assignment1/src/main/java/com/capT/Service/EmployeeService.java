package com.capT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capT.Entity.Employee;
import com.capT.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee e) {
		 return repo.save(e);
	}
	
	public List<Employee> findAll(){
		  return repo.findAll();
	}
	
	public Employee findById(int id) {
		 return repo.findById(id).orElse(null);
	}
	
	public void deleteEmployeeById(int id) {
		  repo.deleteById(id);
	}
	
	public List<Employee> findByEmployeeName(String name) {
		 return repo.findByName(name);
	}
	
	public List<Employee> findByDepartmentName(String department){
		 return repo.findByDepartment(department);
	}
	
	public List<Employee> findByPhone(long phone) {
		 return repo.findByPhone(phone);
	}
	
	public List<Employee> findByEmailName(String email){
		 return repo.findByEmail(email);
	}
}
