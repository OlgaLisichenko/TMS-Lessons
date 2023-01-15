package org.example.singleton;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Double-Checked Locking Singleton
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("Double-Checked \nInitial 1: " + singleton1.getCars());

        Singleton singleton2 = Singleton.getInstance();
        List<Car> cars = singleton2.getCars();
        CarService service = new CarService();
        service.createList(cars);
        System.out.println("New 1: " + singleton1.getCars());
        System.out.println("New 2: " + singleton2.getCars());

        // Inner Class Singleton
        InnerClassSingleton innerSingleton1 = InnerClassSingleton.getInstance();
        System.out.println("Inner Class \nInitial 1: " + innerSingleton1.getCars());

        InnerClassSingleton innerSingleton2 = InnerClassSingleton.getInstance();
        List<Car> carsInner = innerSingleton2.getCars();
        service.deleteCar(carsInner, "1");
        System.out.println("New 1: " + innerSingleton1.getCars());
        System.out.println("New 2: " + innerSingleton2.getCars());

        //Singleton Enum
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        System.out.println("Enum \nInitial 1: " + singletonEnum1.getCars());

        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        List<Car> carsEnum = singletonEnum2.getCars();
        service.createList(carsEnum);

        System.out.println("New 1: " + singletonEnum1.getCars());
        System.out.println("New 2: " + singletonEnum2.getCars());
    }
}