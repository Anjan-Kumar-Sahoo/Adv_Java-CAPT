package com.capT.demo1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hii")
	public String hii()
	{
		return "Byeee";
	}
	@GetMapping("/reg")
	public String register()
	{
		return "Registre Page";
	}
	
}
