package com.example.forfraspringlocaldb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController
{
    @GetMapping("/")
    public String renderIndex(){
        return "/home/index";
    }
    @GetMapping("/")
    public String addCar(){
        return "/home/add-car";
    }

    @GetMapping("/")
    public String carList(){
        return "/home/car-list";
    }





}
