package com.capT.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capT.demo1.Entity.Student;

@RestController
public class DemmoController {

	@GetMapping("/hii")
	public String takeReq()
	{
		return "byee";
	}
	
	@GetMapping("/takeData") // http://lh:8080/takeData?id=1&name=Raju
	public String takeData(@RequestParam int id, @RequestParam String name)
	{
		return "ID = "+id+" Name = "+name;
	}
	@GetMapping("/takeData/{id}") // http://lh:8080/takeData2/1
	public String takeData2(@PathVariable int id)
	{
		return "ID = "+id;
	}
	@GetMapping("/takeData/{id}/{name}") // http://lh:8080/takeData3/1/Anjan
	public String takeData3(@PathVariable int id, @PathVariable String name)
	{
		return "ID = "+id+" Name = "+name;
	}
	@GetMapping("/takeData3/student/{sid}/college/{cid}") // http://lh:8080/takeData3/student/1/college/2
	public String takeData3(@PathVariable int sid, @PathVariable int cid)
	{
		return "Student ID = "+sid+" College ID = "+cid;
	}
	@GetMapping("/takeData4/student/{sid}") // http://lh:8080/takeData3/student/1?cid=2
	public String takeData4(@PathVariable int sid, @RequestParam int cid)
	{
		return "Student ID = "+sid+" College ID = "+cid;
	}
	@GetMapping("/takeData5")
	public String takeData5(@RequestHeader int id, @RequestHeader String name)
	{
		return "Student ID = "+id+" Name = "+name;
	}
	
	@GetMapping("/student")
	public Student getStudent(@RequestBody Student s)
	{
		System.out.println(s.getId());
		System.out.println(s.getName());
		return s;
	}
	
	
}
