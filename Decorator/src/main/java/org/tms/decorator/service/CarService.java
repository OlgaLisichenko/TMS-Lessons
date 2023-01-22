package org.tms.decorator.service;

import org.tms.decorator.domain.CarEntity;

public interface CarService {

    void save(CarEntity car);

    void getById(String id);

    void deleteCar(String id);

    void updateCar(CarEntity car);
}