package org.example.singleton;

import java.util.List;

public class CarService {

    public List<Car> createList(List<Car> cars) {
        cars.add(new Car("2", "AUDI", "2222", "Carl"));
        cars.add(new Car("3", "Mercedes", "3333", "Jack"));
        return cars;
    }

    public void deleteCar(List<Car> cars, String carId) {
        if (carId != null) {
            cars.removeIf(n -> (n.getId().equals(carId)));
        }
    }
}