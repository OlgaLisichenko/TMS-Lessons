package org.example.builder;

import lombok.Data;

@Data
public class Car {

    private String id;
    private String model;
    private String number;
    private Owner owner;

    public static final class CarBuilder {
        private String id;
        private String model;
        private String number;
        private Owner owner;

        public static CarBuilder carBuilder() {
            return new CarBuilder();
        }

        public CarBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CarBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public CarBuilder withOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.setId(id);
            car.setModel(model);
            car.setNumber(number);
            car.setOwner(owner);
            return car;
        }
    }
}