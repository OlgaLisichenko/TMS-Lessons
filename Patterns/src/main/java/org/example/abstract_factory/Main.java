package org.example.abstract_factory;

public class Main {

    public static void main(String[] args) {

        MainService mainService = new MainService();
        mainService.createPhone(new SamsungAbstractFactoryImpl());
        System.out.println("______________");
        mainService.createPhone(new AppleAbstractFactoryImpl());
        System.out.println("______________");
        mainService.createPhone(new HuaweiAbstractFactoryImpl());
    }
}