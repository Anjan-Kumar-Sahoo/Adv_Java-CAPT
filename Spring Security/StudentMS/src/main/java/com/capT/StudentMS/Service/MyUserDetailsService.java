package com.capT.StudentMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capT.StudentMS.Entity.Student;
import com.capT.StudentMS.Repository.StudentRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository repo;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = repo.findByEmail(email)
				.orElseThrow(() 
	-> new UsernameNotFoundException("User not found with email: " + email));
		 
		return User.builder()
				.username(student.getEmail())
				.password(student.getPassword())
				.roles(student.getRole())
				.build();
	}
}
