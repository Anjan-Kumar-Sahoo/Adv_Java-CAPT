package com.capT.demo2.Service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capT.demo2.Entity.Customer;
import com.capT.demo2.Repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository repo;
	private final PasswordEncoder passen;
	
	
	public CustomerService(CustomerRepository repo, PasswordEncoder passen) {
		super();
		this.repo = repo;
		this.passen = passen;
	}
	public Customer register(Customer c)
	{
		String encodedPass = passen.encode(c.getPassword());
		c.setPassword(encodedPass);
		return repo.save(c);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteCustomerById(int id)
	{
		repo.deleteById(id);
	}
	
	public List<Customer> findAllCustomer(){
		return repo.findAll();
	}
	
	@PostAuthorize("returnObject.name == authentication.name")
	public Customer findCustomerById(int id)
	{
		return repo.findById(id).get();
	}
}
