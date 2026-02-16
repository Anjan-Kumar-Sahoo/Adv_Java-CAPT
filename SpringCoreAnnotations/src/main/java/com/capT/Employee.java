package com.capT;

import org.springframework.stereotype.Component;

@Component(value = "emp")
public class Employee {
	private int id ;
	private String name;
	private Laptop laptop;
	
//	public Employee(int id, String name, Laptop laptop) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.laptop = laptop;
//	}
	
	
	
	public Laptop getLaptop() {
		return laptop;
	}



	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}



	public void work()
	{
		System.out.println("Employee is Working...");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
