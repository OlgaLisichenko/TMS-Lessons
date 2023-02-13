package org.tms.employees;

public class Worker extends Employee {

    public Worker(String firstName, String lastName, int workExperience) {
        super(firstName, lastName, workExperience);
        position = Position.WORKER;
    }

    @Override
    public String toString() {
        return "Worker: " +
               super.toString() +
               ", salary = " + calculateSalary(getWorkExperience()) + "\n";
    }
}