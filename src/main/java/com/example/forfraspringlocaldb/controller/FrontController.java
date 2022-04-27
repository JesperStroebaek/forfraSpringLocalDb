package com.example.forfraspringlocaldb.controller;

import com.example.forfraspringlocaldb.Service.CarService;
import com.example.forfraspringlocaldb.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FrontController {
    @Autowired
    CarService carService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Cars> carsList = carService.fetchAll();
        model.addAttribute("cars", carsList);
        return "/home/index";
    }

    @PostMapping("/submit-add-car")
    public String add(@ModelAttribute Cars cars) {
        carService.addCar(cars);
        return "redirect:/car-list";
    }

    @GetMapping("/add-car-succes")
    public String renderAddCarSucces(@PathVariable("id") int id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        return "home/add-car-succes";
    }

    @GetMapping("/delete-car")
    public String delete(@PathVariable("car_id") int CarId) {
        Boolean deleted = carService.deleteCar(CarId);
        if (deleted) {
            return "redirect:/car-list";
        } else {
            return "redirect:/car-list";
        }
    }

    @GetMapping("/")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        return "/home/update";
    }

    @PostMapping("/")
    public String updateCar(@ModelAttribute Cars cars) {
        carService.updateCar(cars.getCarId(), cars);
        return "redirect:/car-list";
    }
}






    /*@GetMapping("/")
    public String addCar(){
        return "/home/add-car";
    }

    @GetMapping("/")
    public String carList(){
        return "/home/car-list";
    } */




