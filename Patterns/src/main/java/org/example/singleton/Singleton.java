package org.example.singleton;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Singleton {

    private List<Car> cars = createListCars();

    private static Singleton singleton;

    private Singleton() {
    }

    public static List<Car> createListCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "BMW", "1111", "Bob"));
        return cars;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}