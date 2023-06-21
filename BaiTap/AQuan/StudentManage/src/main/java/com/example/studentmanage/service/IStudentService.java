package com.example.studentmanage.service;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.model.Student;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByClasses(Classes classes);
    List<Student> searchByName(String name);
    List<Student> sortByPoint();
    List<Student> sortByAge();
}
