package com.capT.Injections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capT.MyConfig;

public class PersonDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Person p = context.getBean("person",Person.class);
		System.out.println(p.getId());
		System.out.println(p.getName());
		AdharCard a = p.getCard();
		a.getinfo();
	}
}
