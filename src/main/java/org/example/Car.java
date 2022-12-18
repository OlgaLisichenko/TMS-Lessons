package org.example;

public class Car {
    private String model;
    private String number;
    private String owner;

    public Car() {
    }

    public Car(String model, String number, String owner) {
        this.model = model;
        this.number = number;
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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
