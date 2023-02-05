package org.tms.employees;

public class SearchService {

    public boolean searchByName(Director director, Employee employee) {
        if (director.workers.contains(employee)) {
            return true;
        } else {
            for (Employee employee2 : director.workers) {
                if (employee2 instanceof Director) {
                    searchByName((Director) employee2, employee);
                    return true;
                }
            }
            return false;
        }
    }
}