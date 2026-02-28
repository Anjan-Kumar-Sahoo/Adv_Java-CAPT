package com.capT.demo1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/lpu")
public class LpuController {

	@PostMapping("/savestudent")
	public  String saveStudent()
	{
		return "Student Saved";
	}
	@PostMapping("/savetrainer")
	public  String saveTrianer()
	{
		return "Trainer Saved";
	}
	@PostMapping("/savesecurity")
	public  String saveSecurity()
	{
		return "Security Gaurd Saved";
	}
}
