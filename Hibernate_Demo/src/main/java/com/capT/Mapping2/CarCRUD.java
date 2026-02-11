package com.capT.Mapping2;

public interface CarCRUD {
	void saveCar(Car c);
	void updateCarModel(int id, String model);
	void updateCarBrand(int id, String brand);
	void deleteCar(int id);
	void fetchCarById(int id);
	void fetchCarByBrand(String brand);
	void findAllCars();
}
