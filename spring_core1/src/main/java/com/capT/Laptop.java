package com.capT;


public class Laptop {
	
	private int id;
	private String name;
	void details()
	{
		System.out.println("This is a brand new laptop.....");
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
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
