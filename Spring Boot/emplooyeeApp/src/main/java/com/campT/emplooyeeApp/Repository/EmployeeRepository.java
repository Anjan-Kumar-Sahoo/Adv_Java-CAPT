package com.campT.emplooyeeApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campT.emplooyeeApp.DTO.EmployeeDto;
import com.campT.emplooyeeApp.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Emp e where name=:name")
	List<Employee> findByName(String name);	
	  
	@Query("select e from Emp e where phone=:phone")
	List<Employee> findByPhone(long phone);
	  
	@Query(nativeQuery=true, value="select * from Emp where email=:email")
	List<Employee> findByEmail(String email);
	
}
