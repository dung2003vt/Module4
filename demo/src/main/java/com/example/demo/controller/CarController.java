package com.example.demo.controller;

import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/cars/list");
        modelAndView.addObject("cars", carService.findAll());
        return modelAndView;
    }
}
