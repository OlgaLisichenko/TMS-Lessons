package org.tms.employees;

import lombok.Data;

@Data
public abstract class Employee {

    private String firstName;
    private String lastName;
    private int workExperience;
    Position position;

    private final int baseRate = 100;

    public Employee(String firstName, String lastName, int workExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
    }

    public int calculateSalary(int workExperience) {
        return baseRate * position.coefficient * workExperience;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}