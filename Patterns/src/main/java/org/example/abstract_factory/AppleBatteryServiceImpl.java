package org.example.abstract_factory;

public class AppleBatteryServiceImpl implements BatteryService {
    @Override
    public Battery createBattery() {
        return new Battery("Apple battery");
    }
}