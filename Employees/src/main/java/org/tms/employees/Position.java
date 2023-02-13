package org.tms.employees;

public enum Position {

    DIRECTOR(2),
    WORKER(1);

    final int coefficient;

    Position(int coefficient) {
        this.coefficient = coefficient;
    }
}