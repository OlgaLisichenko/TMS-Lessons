package org.tms.employees;

import java.util.ArrayList;

public class Director extends Employee {

    ArrayList<Employee> workers = new ArrayList<>();

    public Director(String firstName, String lastName, int workExperience) {
        super(firstName, lastName, workExperience);
        position = Position.DIRECTOR;
    }

    public ArrayList<Employee> assignEmployee(Employee employee) {
        workers.add(employee);
        return workers;
    }

    @Override
    public int calculateSalary(int workExperience) {
        return super.calculateSalary(workExperience) + (workers.size() * 50);
    }

    @Override
    public String toString() {
        return "Director: " +
               super.toString()  +
               ", salary = " + calculateSalary(getWorkExperience()) + "\n" +
               " в подчинении " + workers.size() + " чел.:\n" + workers;
    }
}