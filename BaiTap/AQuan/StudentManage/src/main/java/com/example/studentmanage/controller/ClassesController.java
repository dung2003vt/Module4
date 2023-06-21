package com.example.studentmanage.controller;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.model.Student;
import com.example.studentmanage.service.IClassesService;
import com.example.studentmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ClassesController {

    @Autowired
    private IClassesService classesService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/classes")
    public ModelAndView listClasses() {
        Iterable<Classes> classes = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }

    @GetMapping("/create-classes")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/classes/create");
        modelAndView.addObject("classes", new Classes());
        return modelAndView;
    }

    @PostMapping("/create-classes")
    public ModelAndView saveClasses(@ModelAttribute("classes") Classes classes) {
        classesService.save(classes);
        Iterable<Classes> finAllClasses = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", finAllClasses);
        return modelAndView;
    }

    @GetMapping("/edit-classes/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Classes> classes = classesService.findById(id);
        if (classes.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/classes/edit");
            modelAndView.addObject("classes", classes.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/edit-classes")
    public ModelAndView updateClasses(@ModelAttribute("classes") Classes classes) {
        classesService.save(classes);
        Iterable<Classes> finAllClasses = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", finAllClasses);
        return modelAndView;
    }


    @GetMapping("/delete-classes/{id}")
    public String deleteClasses(@PathVariable Long id ) {
        classesService.remove(id);
        return "redirect:/classes";
    }
    @GetMapping("/view-classes/{id}")
    public ModelAndView viewClasses(@PathVariable("id") Long id){
        Optional<Classes> classesOptional = classesService.findById(id);
        if(!classesOptional.isPresent()){
            return new ModelAndView("/error.404");
        }
        List<Student> students = studentService.findAllByClasses(classesOptional.get());
        ModelAndView modelAndView = new ModelAndView("/classes/view");
        modelAndView.addObject("classes", classesOptional.get());
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
