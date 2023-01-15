package org.example.abstract_factory;

public class AppleAbstractFactoryImpl implements AbstractFactory {
    @Override
    public BatteryService getBatteryService() {
        return new AppleBatteryServiceImpl();
    }

    @Override
    public CameraService getCameraService() {
        return new AppleCameraServiceImpl();
    }

    @Override
    public DisplayService getDisplayService() {
        return new AppleDisplayServiceImpl();
    }
}