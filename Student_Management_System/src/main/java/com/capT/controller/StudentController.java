package com.capT.controller;

import java.util.Scanner;

import com.capT.entity.Student;
import com.capT.service.StudentService;

public class StudentController {

	private static StudentService stu = new StudentService();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		stu.registerStudent("XYZ", 30, 35.55);
//		stu.updateMarks(1, 161.25);
//		Student s = stu.getStudent(1);
//		System.out.println(s);
		stu.deleteStudent(1);
		
	}
}
