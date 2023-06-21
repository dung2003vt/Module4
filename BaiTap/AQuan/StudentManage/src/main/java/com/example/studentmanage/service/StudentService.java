package com.example.studentmanage.service;


import com.example.studentmanage.model.Classes;
import com.example.studentmanage.model.Student;
import com.example.studentmanage.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student customer) {
        studentRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> findAllByClasses(Classes classes) {
        return studentRepository.findAllByClasses(classes);
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.searchByName("%" + name + "%");
    }

    @Override
    public List<Student> sortByPoint() {
        return studentRepository.findAllByOrderByPointAsc();
    }
    @Override
    public List<Student> sortByAge() {
        return studentRepository.findAllByOrderByAgeAsc();
    }
}
