package com.capT;

import org.springframework.stereotype.Component;

//Annotation based Config
@Component(value = "myStudent") // y default it will take the class name with lowercase 
public class Student {
	
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("Studying...");
	}

}
