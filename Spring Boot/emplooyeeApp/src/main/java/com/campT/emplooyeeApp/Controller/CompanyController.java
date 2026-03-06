package com.campT.emplooyeeApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campT.emplooyeeApp.Entity.Company;
import com.campT.emplooyeeApp.Entity.Employee;
import com.campT.emplooyeeApp.Service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService service;

	@PostMapping("/saveCompany")
	public ResponseEntity<Company> saveCompany(@RequestBody Company c)
	{
		Company body = service.saveCompany(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	@PostMapping("/saveCompany2")
	public Company saveCompanyWithMapping(@RequestBody Company c)
	{
		return service.saveCompanyAndWithEmp(c);
	}
	@PostMapping("/saveCompany3/{cid}")
	public Company saveCompanyWithMapping(@PathVariable int cid,@RequestBody List<Employee> employees )
	{
		return service.saveEmployeesToExitingCompany(cid,employees);
	}
	
	@GetMapping("/divide/{sid}/{cid}")
	public String divide(@PathVariable int sid, @PathVariable int cid)
	{
		return " result = " + sid/cid;
	}
	
	@GetMapping("/company/{id}")
	public Company findCompanyById(@PathVariable int id)
	{
		return service.findCompanyById(id);
	}
}
