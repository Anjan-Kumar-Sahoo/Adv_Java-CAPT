package com.capT.Mapping2;

import java.util.Scanner;

public class CarEngineMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarCRUD carCrud = new CarCRUDimplementation();
		EngineCRUD engineCrud = new EngineCRUDimplementation();
		
		while (true) {
			System.out.println("\n========== CAR & ENGINE MANAGEMENT SYSTEM ==========");
			System.out.println("1.  Save Car");
			System.out.println("2.  Update Car Model");
			System.out.println("3.  Update Car Brand");
			System.out.println("4.  Delete Car");
			System.out.println("5.  Fetch Car by ID");
			System.out.println("6.  Fetch Car by Brand");
			System.out.println("7.  Find All Cars");
			System.out.println("8.  Save Engine");
			System.out.println("9.  Update Engine CC");
			System.out.println("10. Delete Engine");
			System.out.println("11. Fetch Engine by ID");
			System.out.println("12. Fetch Engine by CC");
			System.out.println("13. Find All Engines");
			System.out.println("0.  Exit");
			System.out.println("====================================================");
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine(); // consume newline
			
			switch (choice) {
				case 1: // Save Car
					System.out.print("Enter Car ID: ");
					int carId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Car Model: ");
					String model = sc.nextLine();
					System.out.print("Enter Car Brand: ");
					String brand = sc.nextLine();
					System.out.print("Enter Engine ID: ");
					int engineId = sc.nextInt();
					System.out.print("Enter Engine CC: ");
					int cc = sc.nextInt();
					
					Engine engine = new Engine();
					engine.setId(engineId);
					engine.setCc(cc);
					
					Car car = new Car();
					car.setId(carId);
					car.setModel(model);
					car.setBrand(brand);
					car.setEngine(engine);
					
					engineCrud.saveEngine(engine);
					carCrud.saveCar(car);
					break;
					
				case 2: // Update Car Model
					System.out.print("Enter Car ID: ");
					int updateCarId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter New Model: ");
					String newModel = sc.nextLine();
					carCrud.updateCarModel(updateCarId, newModel);
					break;
					
				case 3: // Update Car Brand
					System.out.print("Enter Car ID: ");
					int updateBrandCarId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter New Brand: ");
					String newBrand = sc.nextLine();
					carCrud.updateCarBrand(updateBrandCarId, newBrand);
					break;
					
				case 4: // Delete Car
					System.out.print("Enter Car ID to delete: ");
					int deleteCarId = sc.nextInt();
					carCrud.deleteCar(deleteCarId);
					break;
					
				case 5: // Fetch Car by ID
					System.out.print("Enter Car ID: ");
					int fetchCarId = sc.nextInt();
					carCrud.fetchCarById(fetchCarId);
					break;
					
				case 6: // Fetch Car by Brand
					System.out.print("Enter Brand: ");
					String searchBrand = sc.nextLine();
					carCrud.fetchCarByBrand(searchBrand);
					break;
					
				case 7: // Find All Cars
					carCrud.findAllCars();
					break;
					
				case 8: // Save Engine
					System.out.print("Enter Engine ID: ");
					int newEngineId = sc.nextInt();
					System.out.print("Enter Engine CC: ");
					int newCc = sc.nextInt();
					
					Engine newEngine = new Engine();
					newEngine.setId(newEngineId);
					newEngine.setCc(newCc);
					engineCrud.saveEngine(newEngine);
					break;
					
				case 9: // Update Engine CC
					System.out.print("Enter Engine ID: ");
					int updateEngineId = sc.nextInt();
					System.out.print("Enter New CC: ");
					int updatedCc = sc.nextInt();
					engineCrud.updateEngineCC(updateEngineId, updatedCc);
					break;
					
				case 10: // Delete Engine
					System.out.print("Enter Engine ID to delete: ");
					int deleteEngineId = sc.nextInt();
					engineCrud.deleteEngine(deleteEngineId);
					break;
					
				case 11: // Fetch Engine by ID
					System.out.print("Enter Engine ID: ");
					int fetchEngineId = sc.nextInt();
					engineCrud.fetchEngineById(fetchEngineId);
					break;
					
				case 12: // Fetch Engine by CC
					System.out.print("Enter Engine CC: ");
					int fetchCc = sc.nextInt();
					engineCrud.fetchEngineByCC(fetchCc);
					break;
					
				case 13: // Find All Engines
					engineCrud.findAllEngines();
					break;
					
				case 0: // Exit
					System.out.println("Exiting... Thank you!");
					sc.close();
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
