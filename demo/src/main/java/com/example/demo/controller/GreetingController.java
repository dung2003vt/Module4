package com.example.demo.controller;

import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("username", "Việt Nam");
        return "/views/demo";
    }

    @GetMapping("/greeting1")
    public String greeting1(ModelMap modelMap) {
        modelMap.addAttribute("user", new User("duongdepzai", "Dương"));
        return "/products/demo";
    }
}
