package org.example.abstract_factory;

public interface AbstractFactory {

    BatteryService getBatteryService();

    CameraService getCameraService();

    DisplayService getDisplayService();
}