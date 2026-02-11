package com.capT.Mapping2;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarCRUDimplementation implements CarCRUD {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public void saveCar(Car c) {
		et.begin();
		em.persist(c);
		et.commit();
		System.out.println("Car Saved.");
	}

	@Override
	public void updateCarModel(int id, String model) {
		Car c = em.find(Car.class, id);
		if (c != null) {
			c.setModel(model);
			et.begin();
			em.merge(c);
			et.commit();
			System.out.println("Car Model Updated.");
		} else {
			System.out.println("Car not found with ID: " + id);
		}
	}

	@Override
	public void updateCarBrand(int id, String brand) {
		Car c = em.find(Car.class, id);
		if (c != null) {
			c.setBrand(brand);
			et.begin();
			em.merge(c);
			et.commit();
			System.out.println("Car Brand Updated.");
		} else {
			System.out.println("Car not found with ID: " + id);
		}
	}

	@Override
	public void deleteCar(int id) {
		Car c = em.find(Car.class, id);
		if (c != null) {
			et.begin();
			em.remove(c);
			et.commit();
			System.out.println("Car Deleted.");
		} else {
			System.out.println("Car not found with ID: " + id);
		}
	}

	@Override
	public void fetchCarById(int id) {
		Car c = em.find(Car.class, id);
		if (c != null) {
			System.out.println("Id: " + c.getId());
			System.out.println("Model: " + c.getModel());
			System.out.println("Brand: " + c.getBrand());
			if (c.getEngine() != null) {
				System.out.println("Engine ID: " + c.getEngine().getId());
				System.out.println("Engine CC: " + c.getEngine().getCc());
			}
		} else {
			System.out.println("Car not found with ID: " + id);
		}
	}

	@Override
	public void fetchCarByBrand(String brand) {
		Query q = em.createQuery("select c from Car c where c.brand = :brand");
		q.setParameter("brand", brand);
		List<Car> carList = q.getResultList();
		
		if (carList.isEmpty()) {
			System.out.println("No cars found with brand: " + brand);
		} else {
			for (Car c : carList) {
				System.out.println("\nId: " + c.getId());
				System.out.println("Model: " + c.getModel());
				System.out.println("Brand: " + c.getBrand());
				if (c.getEngine() != null) {
					System.out.println("Engine ID: " + c.getEngine().getId());
					System.out.println("Engine CC: " + c.getEngine().getCc());
				}
			}
		}
	}

	@Override
	public void findAllCars() {
		Query q = em.createQuery("select c from Car c");
		List<Car> carList = q.getResultList();
		
		if (carList.isEmpty()) {
			System.out.println("No cars found.");
		} else {
			for (Car c : carList) {
				System.out.println("\nId: " + c.getId());
				System.out.println("Model: " + c.getModel());
				System.out.println("Brand: " + c.getBrand());
				if (c.getEngine() != null) {
					System.out.println("Engine ID: " + c.getEngine().getId());
					System.out.println("Engine CC: " + c.getEngine().getCc());
				}
			}
		}
	}
}
