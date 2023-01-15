package org.example.abstract_factory;

public class SamsungBatteryServiceImpl implements BatteryService{
    @Override
    public Battery createBattery() {
        return new Battery("Samsung battery");
    }
}