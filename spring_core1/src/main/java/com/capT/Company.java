package com.capT;

import java.util.Map;

public class Company {

	private Map<String, String> employees;

    public Company(Map<String, String> employees) {
        this.employees = employees;
    }

    public void showEmployees() {
    		System.out.println("Priting Employess in the Company --- ");
        employees.forEach((k, v) -> 
            System.out.println(k + " : " + v));
    }
}
