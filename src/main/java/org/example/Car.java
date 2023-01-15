package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private String id;
    private String model;
    private String number;
    private String owner;
}