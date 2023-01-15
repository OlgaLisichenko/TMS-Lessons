package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class Seller implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Customer argCustomer = (Customer) arg;
        System.out.println("The seller takes the order from the " + argCustomer);
    }
}