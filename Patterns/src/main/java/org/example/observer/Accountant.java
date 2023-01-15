package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class Accountant implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Customer argCustomer = (Customer) arg;
        System.out.println("The accountant prepares a report on the order of " + argCustomer);
    }
}