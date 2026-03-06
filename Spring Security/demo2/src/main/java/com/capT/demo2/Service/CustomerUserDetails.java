package com.capT.demo2.Service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capT.demo2.Entity.Customer;
import com.capT.demo2.Repository.CustomerRepository;

public class CustomerUserDetails implements UserDetails{

	private Customer customer;
	

	public CustomerUserDetails(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(customer.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getName();
	}

}
