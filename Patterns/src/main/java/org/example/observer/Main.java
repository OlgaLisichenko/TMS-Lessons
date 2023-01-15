package org.example.observer;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        service.addObserver(new Seller());
        service.addObserver(new Cashier());
        service.addObserver(new Accountant());

        service.createOrder(new Customer("John Smith"));
    }
}