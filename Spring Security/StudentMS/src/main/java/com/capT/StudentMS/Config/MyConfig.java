package com.capT.StudentMS.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration @EnableWebSecurity @EnableMethodSecurity
public class MyConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf((c)->c.disable());
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/actuator/**").permitAll()
		.requestMatchers("/student/save").permitAll()
		.requestMatchers("/student/find","/student/find/page").hasRole("ADMIN")
		.requestMatchers("/student/update/**","/student/delete/**","/student/upload/**","/student/download/**").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated());
		http.cors(c->{});
		http.formLogin(Customizer.withDefaults());//for chrome
		http.httpBasic(Customizer.withDefaults());//for postman
		return http.build();
	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new  BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource()
	{
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(List.of("http://localhost:3000"));
		config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource() ;
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}

