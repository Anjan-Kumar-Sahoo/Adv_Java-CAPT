package com.capT.M_O_Mappping;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Department {
	
	@Id
	private int id;
	private int noEmp;
	private String name;
	
	@ManyToOne
	private Company c;

	public Department(int id, int noEmp, String name, Company c) {
		super();
		this.id = id;
		this.noEmp = noEmp;
		this.name = name;
		this.c = c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoEmp() {
		return noEmp;
	}

	public void setNoEmp(int noEmp) {
		this.noEmp = noEmp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getC() {
		return c;
	}

	public void setC(Company c) {
		this.c = c;
	}
	
	
	

}
