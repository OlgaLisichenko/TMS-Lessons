package org.example.abstract_factory;

public class SamsungAbstractFactoryImpl implements AbstractFactory {
    @Override
    public BatteryService getBatteryService() {
        return new SamsungBatteryServiceImpl();
    }

    @Override
    public CameraService getCameraService() {
        return new SamsungCameraServiceImpl();
    }

    @Override
    public DisplayService getDisplayService() {
        return new SamsungDisplayServiceImpl();
    }
}