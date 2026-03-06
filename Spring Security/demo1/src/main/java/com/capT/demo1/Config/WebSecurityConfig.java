package com.capT.demo1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity https)
	{
		https.authorizeHttpRequests((req) ->
		req.requestMatchers("/reg","/error").permitAll()
		.anyRequest().authenticated());
		
		//or
		//req.anyRequest().authenticated());
		
		// .denyAll() and .permitAll()
		
		https.formLogin(Customizer.withDefaults());//for chrome
		https.httpBasic(Customizer.withDefaults());//for postman
		return https.build();
	}
	
	@Bean
	public UserDetailsService detailsService()
	{
		UserDetails user1 = User
				.withUsername("Anjan")
				.password("{noop}123")
				.roles("read")
				.build();
		UserDetails user2 = User
				.withUsername("Anjali")
				.password("{noop}1097")
				.roles("read")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
}
