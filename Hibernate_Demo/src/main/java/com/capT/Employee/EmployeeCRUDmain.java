package com.capT.Employee;

import java.util.Scanner;

public class EmployeeCRUDmain {
	public static void main(String[] args) 
	{
		EmployeeCRUDimplementation ip = new EmployeeCRUDimplementation();
		Scanner sc = new Scanner(System.in);
		int id;
		while(true)
		{
			System.out.println("\n--- Emloyee Table MENU ---");
	        System.out.println("1. Insert");
	        System.out.println("2. Update Name");
	        System.out.println("3. Update Name");
	        System.out.println("4. Delete");
	        System.out.println("5. Select ");
	        System.out.println("6. Exit");
	        System.out.print("Enter your choice: ");
			int c = sc.nextInt();
			switch(c) {
				case 1: Employee e = new Employee();
						System.out.println("Enter Id : ");
						e.setSid(sc.nextInt());
						System.out.println("Enter Name : ");
						e.setName(sc.next()+sc.nextLine());
						System.out.println("Enter Phone Number : ");
						e.setPhno(sc.nextLong());
						ip.saveEmployee(e);
						break;
				case 2: System.out.println("Enter Id : ");
						id = sc.nextInt();
						System.out.println("Enter Name : ");
						String name = sc.next()+sc.nextLine();
						ip.updateEmployeeName(id, name);
						break;
				case 3: System.out.println("Enter Id : ");
						id = sc.nextInt();
						System.out.println("Enter Phone : ");
						Long ph = sc.nextLong();
						ip.updateEmployeePhone(c, ph);
						break;
				case 4: System.out.println("Enter Id to Delete : ");
						id = sc.nextInt();
						ip.deleteEmployee(id);
						break;
				case 5: System.out.println("Enter Id get Details: ");
						id = sc.nextInt();
						ip.fetchEmployee(id);
						break;
				case 6: System.out.println("---Exiting--- Byeeee");
						sc.close();
						System.exit(0);
				default: System.out.println("Wrong Choice");;
			}
		}
	}
}
