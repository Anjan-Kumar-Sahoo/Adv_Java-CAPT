package com.capT;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		
//		BeanFactory b;
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("Main Started: ");
		Student s = context.getBean("StudentObj",Student.class);
		Employee w = context.getBean("EmployeeObj",Employee.class);
		Company c = context.getBean("company",Company.class);
		c.showEmployees();
		System.out.println(s);
		s.study();
		System.out.println(w);
		w.work();
		System.out.println("Main Ennded: ");
		
//		Employee emp = context.getBean("EmployeeObj",Employee.class);
//		System.out.println(emp.getId() + " - "+emp.getName()+" - Laptop : "+emp.getLaptop());
//		emp.work();
//		
//		Laptop lap = context.getBean("myLap",Laptop.class);
//		System.out.println(lap.getId() + " - "+lap.getName());
//		lap.details();
		

	}
}
