package com.capT.Mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	@OneToOne
	Adhar adhar;
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
	public Adhar getAdhar() {
		return adhar;
	}
	public void setAdhar(Adhar adhar) {
		this.adhar = adhar;
	}
	
	public static void main(String ...args)
	{
		
	}

}
