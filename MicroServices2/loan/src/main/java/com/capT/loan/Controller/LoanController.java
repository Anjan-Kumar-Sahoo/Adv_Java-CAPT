package com.capT.loan.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping
	public String connect()
	{
		return "This is loan application";
	}
}
