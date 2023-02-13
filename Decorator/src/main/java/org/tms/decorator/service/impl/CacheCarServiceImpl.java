package org.tms.decorator.service.impl;

import org.tms.decorator.domain.CarEntity;
import org.tms.decorator.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CacheCarServiceImpl implements CarService {

    List<CarEntity> cache = new ArrayList<>();

    CarService service;

    public CacheCarServiceImpl(CarService service) {
        this.service = service;
    }

    @Override
    public void save(CarEntity car) {
        if (cache.contains(car)) {
            System.out.println("The car " + car + " already exists");
        } else {
            service.save(car);
            cache.add(car);
            System.out.println("The car " + car + " saved in cache");
        }
    }

    @Override
    public void getById(String id) {
        CarEntity carById = cache.stream().filter(c -> c.getId().equals(id)).findAny().orElseThrow();
        System.out.println("The car by id " + id + " from cache: " + carById);
    }

    @Override
    public void deleteCar(String id) {
        CarEntity carById = cache.stream().filter(c -> c.getId().equals(id)).findAny().orElseThrow();
        service.deleteCar(id);
        cache.remove(carById);
        System.out.println("The car with id " + id + " deleted from cache");
    }

    @Override
    public void updateCar(CarEntity car) {
        boolean removeIf = cache.removeIf(c -> c.getId().equals(car.getId()));
            if (removeIf) {
            service.updateCar(car);
            cache.add(car);
            System.out.println("The car with id " + car.getId() + " updated in cache: " + car);
        } else {
            System.out.println("The car with id " + car.getId() + " doesn't exist");
        }
    }
}