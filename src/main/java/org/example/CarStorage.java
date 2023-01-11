package org.example;

import java.util.HashMap;

public class CarStorage {

    private static HashMap<String, Car> cars = createHashMap();

    private static HashMap<String, Car> createHashMap() {
        HashMap<String, Car> cars = new HashMap<>();
        cars.put("1", new Car("BMW", "1111", "Bob"));
        cars.put("2", new Car("AUDI", "2222", "Carl"));
        cars.put("3", new Car("Mercedes", "3333", "Jack"));
        return cars;
    }

    public static HashMap<String, Car> getCars() {
        return cars;
    }
}