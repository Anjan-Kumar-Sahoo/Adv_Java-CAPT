package com.capT;

import java.util.Arrays;

public class Student {
	
	private String name;
	private String[] subjects;
	@Override
	public String toString() {
		return "Student [name=" + name + ", subjects=" + Arrays.toString(subjects) + "]";
	}


	public Student(String name, String[] subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getSubjects() {
		return subjects;
	}


	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}


	public void study() {
		// TODO Auto-generated method stub
		System.out.println("Studying...");
	}

}
