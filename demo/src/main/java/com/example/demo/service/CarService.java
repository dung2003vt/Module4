package com.example.demo.service;

import com.example.demo.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> carList;

    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "C200", "Mec", 15D));
    }

    public List<Car> findAll() {
        return carList;
    }
}
