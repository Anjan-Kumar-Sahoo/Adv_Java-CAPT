package com.capT.account.Controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {

	@GetMapping
	public String connect()
	{
		return "This is Account application";
	}
	@GetMapping("/connect")
	public ResponseEntity<String> connectiongToUser()
	{
		String url="http://localhost:8888/DEPOSITE";
		RestTemplate rt = new RestTemplate();
		return rt.exchange(url, HttpMethod.GET, null, String.class);
	}
}
