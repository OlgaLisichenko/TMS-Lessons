package org.example;

public class Car {
    private String model;
    private String number;
    private String owner;

    public Car(String model, String number, String owner) {
        this.model = model;
        this.number = number;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car {" +
               "model = '" + model + '\'' +
               ", number = '" + number + '\'' +
               ", owner = '" + owner + '\'' +
               '}';
    }
}
