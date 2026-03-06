package com.capT.demo2.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capT.demo2.Entity.Customer;
import com.capT.demo2.Service.CustomerService;

@RestController
public class CustomerContoller {

	private final CustomerService service;

	public CustomerContoller(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer c)
	{
		return service.register(c);
	}
	
	@GetMapping("/public")
	public String homePage()
	{
		return "Public Page";
	}
	
	@GetMapping("/account")
	public String accountCustomer()
	{
		return "Account Page";
	}
	@GetMapping("/update")
	public String updateCustomer() {
		return "Update page";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		service.deleteCustomerById(id);
		return "Customer Deleted";
	}
	@GetMapping("/find/{id}")
	public Customer findCustomer(@PathVariable int id) {
		return service.findCustomerById(id);
	}
}
