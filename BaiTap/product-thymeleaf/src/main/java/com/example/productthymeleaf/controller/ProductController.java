package com.example.productthymeleaf.controller;

import com.example.productthymeleaf.model.Product;
import com.example.productthymeleaf.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ICRUDService productService;

    @GetMapping
    public ModelAndView findAll() {
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String search) {
        List<Product> products = productService.searchByName(search);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("product", products);
        return modelAndView;
    }
}
