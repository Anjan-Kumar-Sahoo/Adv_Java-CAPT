package com.capT.controller;

import java.util.List;
import java.util.Scanner;

import com.capT.entity.Course;
import com.capT.entity.Student;
import com.capT.service.CourseService;

public class CourseController {
	
	private static CourseService courseService = new CourseService();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Register Course
		//Course c = courseService.registerCourse("Core Java", "Mr. A.K.S");
		//Print Course
		//Update Trainer
//		courseService.updateTrainer(1,"Mr.Sandeep");
		// enroll stu
//		courseService.enrollStudent(1, 1);
//		courseService.getStudentsEnrolled(1);
		
		
		System.out.println(courseService.getCourse(1));
		sc.close();
	}
}
