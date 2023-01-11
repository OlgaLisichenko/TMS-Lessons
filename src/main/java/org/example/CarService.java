package org.example;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> getAll();

    List<Car> getById(String id);

    void deleteCar(String id);

    void updateCar(Car car);
}