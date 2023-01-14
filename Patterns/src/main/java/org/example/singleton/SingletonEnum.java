package org.example.singleton;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum SingletonEnum {

    INSTANCE;

    List<Car> cars = new ArrayList<>();
}