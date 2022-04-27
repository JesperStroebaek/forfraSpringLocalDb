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

    public Cars findCarById(int id) {
        return carsRepo.findCarById(id);
    }

    public Boolean deleteCar(int id) {
        return carsRepo.deleteCar(id);
    }

    public void updateCar(int id, Cars c) {
        carsRepo.updateCar(id, c);
    }
}









