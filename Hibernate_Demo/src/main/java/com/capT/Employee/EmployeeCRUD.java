package com.capT.Employee;

public interface EmployeeCRUD {
	void saveEmployee(Employee s);
	void updateEmployeeName(int id, String name);
	void updateEmployeePhone(int id, Long phno);
	void deleteEmployee(int id);
	void fetchEmployee(int id);
	void findAllEmployee();

}
