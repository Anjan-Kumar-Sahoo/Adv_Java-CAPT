package com.campT.emplooyeeApp.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campT.emplooyeeApp.DTO.EmployeeDto;
import com.campT.emplooyeeApp.Entity.Employee;
import com.campT.emplooyeeApp.Repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	public EmployeeDto entityToDto(Employee e)
	{
		EmployeeDto edto = new EmployeeDto();
		edto.setName(e.getName());
		edto.setAge(e.getAge());
		edto.setEmail(e.getEmail());
		edto.setPhone(e.getPhone());
		return edto;
	}
	
	public EmployeeDto saveEmployee(Employee e) {
		 return entityToDto(repo.save(e));
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
	
	public List<Employee> findByPhone(long phone) {
		 return repo.findByPhone(phone);
	}
	
	public List<Employee> findByEmailName(String email){
		 return repo.findByEmail(email);
	}
}

