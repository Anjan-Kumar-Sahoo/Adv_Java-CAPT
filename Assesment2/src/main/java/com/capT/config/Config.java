package com.capT.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.capT")
@Configuration
public class Config {
	@Bean
	public EntityManagerFactory getEMF()
	{
		return Persistence.createEntityManagerFactory("dev");
	}
}
