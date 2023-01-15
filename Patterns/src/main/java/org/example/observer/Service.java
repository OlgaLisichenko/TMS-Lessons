package org.example.observer;

import java.util.Observable;

public class Service extends Observable {

    public void createOrder(Customer customer) {
        System.out.println("Create order");
        setChanged();
        notifyObservers(customer);
    }
}