package com.capT.demo2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity @EnableMethodSecurity
public class MyConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf((c)->c.disable());
		
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/register","/public","/error").permitAll()
		.requestMatchers("/delete").hasRole("ADMIN")
		.requestMatchers("/upadte").hasAllRoles("ADMIN","USER")
		.anyRequest().authenticated());
		
		http.formLogin(Customizer.withDefaults());//for chrome
		http.httpBasic(Customizer.withDefaults());//for postman
		return http.build();
	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new  BCryptPasswordEncoder();
	}
}
