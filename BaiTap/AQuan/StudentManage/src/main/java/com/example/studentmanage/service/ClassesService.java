package com.example.studentmanage.service;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public void save(Classes Classes) {
        classesRepository.save(Classes);
    }

    @Override
    public void remove(Long id) {
        classesRepository.deleteById(id);
    }
}
