package org.example.singleton;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InnerClassSingleton {

    private List<Car> cars = createListCars();

    private InnerClassSingleton() {
    }

    private static class SingletonHelper {
        private static final InnerClassSingleton INNER_SINGLETON = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHelper.INNER_SINGLETON;
    }

    public static List<Car> createListCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "BMW", "1111", "Bob"));
        return cars;
    }
}