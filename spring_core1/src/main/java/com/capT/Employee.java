package com.capT;

import java.util.List;

import org.springframework.stereotype.Component;

@Component(value = "emp")
public class Employee {
	private int id ;
	private String name;
	private Laptop laptop;
	private List<String> skills;
	
	

    public Employee(int id, String name, Laptop laptop, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.laptop = laptop;
		this.skills = skills;
	}
    
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", laptop=" + laptop + ", skills=" + skills + "]";
	}
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
