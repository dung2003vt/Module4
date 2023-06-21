package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
//đánh dấu đây là 1 controller, tiếp nhận và xử lý request
//đánh dấu đây là 1 Bean, hỗ trợ việc IoCContainer tìm thấy và khởi tạo
@RequestMapping("/products")
//annotation hỗ trợ ánh xạ URL request tới controller tương ứng
//giá trị của ánh xạ
public class ProductController {

    //@PathVariables: annotation hỗ trợ hứng giá trị biến trên đường
    //biến trên đường dẫn: http://localhost:8080/products/2
    //số 2 ở cuối được gọi là biến trên đường dẫn
    //cách hứng giá trị trên URI của method: @GetMapping(/{id})

    //@RequestParam: annotation hỗ trợ hứng giá trị của request dưới dạng key-value (tham số đường dẫn)
    //tham số đường dẫn: http://localhost:8080/products?name='C0223I1'
    //hứng giá trị dựa theo key của param đó

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", new ArrayList<>());
        return "/products/demo";
    }

    @GetMapping("/{id}/{abc}")
    public String findById(@PathVariable("abc") String name, @PathVariable Long id) {
        return "abc";
    }

    @GetMapping("/create")
    public ModelAndView formCreat() {
        ModelAndView modelAndView = new ModelAndView("/products/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Model model, @RequestParam String username,
                         @RequestParam Integer age) {
        model.addAttribute("username", username);
        model.addAttribute("age", age);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable Long id) {
        return "abc";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        return "abc";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "abc";
    }
}
