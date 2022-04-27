package com.example.forfraspringlocaldb.Service;

import com.example.forfraspringlocaldb.model.Cars;
import com.example.forfraspringlocaldb.repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarsRepo carsRepo;

    public List<Cars> fetchAll() {
        return carsRepo.fetchAll();
    }

    public void addCar(Cars c) {
        carsRepo.addCar(c);
    }

    public Cars findCarById(int carId) {
        return carsRepo.findCarById(carId);
    }

    public Boolean deleteCar(int carId) {
        return carsRepo.deleteCar(carId);
    }

    public void updateCar(int carId, Cars c) {
        carsRepo.updateCar(carId, c);
    }
}









