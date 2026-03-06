package com.campT.emplooyeeApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campT.emplooyeeApp.Entity.Company;
import com.campT.emplooyeeApp.Entity.Employee;
import com.campT.emplooyeeApp.Exception.CompanyNotFoundException;
import com.campT.emplooyeeApp.Repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repo;
	
	public Company saveCompany(Company c)
	{
		return repo.save(c);
	}

	public Company saveCompanyAndWithEmp(Company c) {
		c.getEmployees().forEach((e)->e.setCompany(c));
		return repo.save(c);
	}

	public Company saveEmployeesToExitingCompany(int cid, List<Employee> employees) {
		Company c = repo.findById(cid).orElse(null);
		c.getEmployees().addAll(employees);
		return saveCompanyAndWithEmp(c);
	}
	
	public Company findCompanyById(int id)
	{
		return repo.findById(id).orElseThrow( 
				() -> new CompanyNotFoundException(" Company with "+id+" not  Founnd")); 
	}
	

}
