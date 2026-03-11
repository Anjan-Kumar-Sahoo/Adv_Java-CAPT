package com.capT.deposite.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositeController {

	@GetMapping
	public String connect()
	{
		return "This is Deposite application";
	}
}
