package com.capT.Employee;

import java.util.Scanner;

import com.capT.Driver;

public class OpsEmployee extends Driver {
	static Scanner sc = new Scanner(System.in);
	
	private static void saveEmployee()
	{
		Employee e = new Employee();
		System.out.println("Enter Id : ");
		e.setSid(sc.nextInt());
		System.out.println("Enter Name : ");
		e.setName(sc.next()+sc.nextLine());
		System.out.println("Enter Phone Number : ");
		e.setPhno(sc.nextLong());
		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("Employee Saved.");
	}
	

	private static void selectEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Enter Id to get Details : ");
		int id = sc.nextInt();
		Employee e = em.find(Employee.class, id);
		
		System.out.println("Id : "+e.getSid());
		System.out.println("Name : "+e.getName());
		System.out.println("Ph No. :"+e.getPhno());
	}

	private static void updateDetail() {
		// TODO Auto-generated method stub
		System.out.println("Enter Id to Update : ");
		int id = sc.nextInt();
		Employee e = em.find(Employee.class, id);
		System.out.println("Enter Upfated Name : ");
		e.setName(sc.next()+sc.nextLine());
		System.out.println("Enter Updated Phone Number : ");
		e.setPhno(sc.nextLong());
		
		et.begin();
		em.merge(e);
		et.commit();
		System.out.println("Employee Updated.");

	}
	private static void deleteEMPbyID() {
		// TODO Auto-generated method stub
		System.out.println("Enter Id to Delete : ");
		int id = sc.nextInt();
		Employee e = em.find(Employee.class, id);
		
		et.begin();
		em.remove(e);
		et.commit();
		System.out.println("Employee Deleted.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.println("\n--- Emloyee Table MENU ---");
	        System.out.println("1. Insert");
	        System.out.println("2. Update");
	        System.out.println("3. Delete");
	        System.out.println("4. Select ");
	        System.out.println("5. Exit");
	        System.out.print("Enter your choice: ");
			int c = sc.nextInt();
			switch(c) {
				case 3: deleteEMPbyID();
						break;
				case 2: updateDetail();
						break;
				case 1: saveEmployee();
						break;
				case 4: selectEmployee();
						break;
				case 5: System.out.println("---Exiting--- Byeeee");
						sc.close();
						System.exit(0);
				default: System.out.println("Wrong Choice");;
			}
		}
	}
}
