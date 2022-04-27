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

    @GetMapping("/")
    public String index(Model model) {
        List<Cars> carsList = carService.fetchAll();
        model.addAttribute("cars", carsList);
        return "/home/index";
    }


    @GetMapping("/")
    public String renderIndex() {
        return "/home/index";
    }

    @PostMapping("/")
    public String add(@ModelAttribute Cars cars) {
        carService.addCar(cars);
        return "redirect/";
    }

    @GetMapping("/")
    public String viewOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        return "home/viewOne";
    }

    @GetMapping("/")
    public String delete(@PathVariable("id") int id) {
        Boolean deleted = carService.deleteCar(id);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        return "home/update";
    }

    @PostMapping("/")
    public String updateCar(@ModelAttribute Cars cars) {
        carService.updateCar(cars.getCarId(), cars);
        return "redirect:/";
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




