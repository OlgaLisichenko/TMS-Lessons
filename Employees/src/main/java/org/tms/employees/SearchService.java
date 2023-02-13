package org.tms.employees;

public class SearchService {

    public boolean searchByName(Director director, String lastName) {
        String listToString = director.workers.toString();
        if (listToString.contains(lastName)) {
            return true;
        } else {
            for (Employee employee : director.workers) {
                if (employee instanceof Director) {
                    searchByName((Director) employee, lastName);
                    return false;
                }
            }
            return false;
        }
    }
}