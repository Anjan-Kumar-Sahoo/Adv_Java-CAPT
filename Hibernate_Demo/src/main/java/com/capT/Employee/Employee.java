package com.capT.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private int eid;
	private String name;
	private long phno;
	public int getSid() {
		return eid;
	}
	public void setSid(int sid) {
		this.eid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	
	

}
