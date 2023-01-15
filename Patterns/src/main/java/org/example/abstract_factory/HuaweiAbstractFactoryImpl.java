package org.example.abstract_factory;

public class HuaweiAbstractFactoryImpl implements AbstractFactory {
    @Override
    public BatteryService getBatteryService() {
        return new HuaweiBatteryServiceImpl();
    }

    @Override
    public CameraService getCameraService() {
        return new AppleCameraServiceImpl();
    }

    @Override
    public DisplayService getDisplayService() {
        return new SamsungDisplayServiceImpl();
    }
}