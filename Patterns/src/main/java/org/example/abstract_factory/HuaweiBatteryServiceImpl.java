package org.example.abstract_factory;

public class HuaweiBatteryServiceImpl implements BatteryService {
    @Override
    public Battery createBattery() {
        return new Battery("Huawei battery");
    }
}