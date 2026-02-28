package com.capT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capT.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	
	@Query("select e from Employee e where name=:name")
	List<Employee> findByName(String name);	
	
	@Query("select e from Employee e where department=:department")
	List<Employee> findByDepartment(String department);
	  
	@Query("select e from Employee e where phone=:phone")
	List<Employee> findByPhone(long phone);
	  
	@Query(nativeQuery=true, value="select * from employee where email=:email")
	List<Employee> findByEmail(String email);
}
 