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

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return " model: " + model +
               ", number: " + number +
               ", owner: " + owner;
    }
}
