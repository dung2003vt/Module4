package com.example.studentmanage.controller;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.model.Student;
import com.example.studentmanage.service.IClassesService;
import com.example.studentmanage.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassesService classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes() {
        return classesService.findAll();
    }

    @GetMapping("/create-student")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/students")
    public ModelAndView listStudents() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/edit-student/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.remove(id);
        return "redirect:/students";
    }
    @PostMapping("/search")
    public ModelAndView searchByName(@RequestParam String name){
        List<Student> students =studentService.searchByName(name);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sort-by-point")
    public ModelAndView sortByPoint(){
        List<Student> students = studentService.sortByPoint();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sort-by-age")
    public ModelAndView sortByAge(){
        List<Student> students = studentService.sortByAge();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}


