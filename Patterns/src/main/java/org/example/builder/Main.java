package org.example.builder;

import org.example.builder.Car.CarBuilder;

public class Main {

    public static void main(String[] args) {

        Car builder = CarBuilder.carBuilder()
                .withId("1")
                .withModel("Audi")
                .withNumber("1234AA")
                .withOwner(Owner.builder()
                        .name("John")
                        .surname("Smith")
                        .age(55)
                        .build())
                .build();

        System.out.println(builder);
    }
}