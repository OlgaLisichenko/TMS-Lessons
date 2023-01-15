package org.example.abstract_factory;

public class MainService {

    public void createPhone(AbstractFactory abstractFactory) {
        BatteryService batteryService = abstractFactory.getBatteryService();
        Battery battery = batteryService.createBattery();
        System.out.println(battery);

        CameraService cameraService = abstractFactory.getCameraService();
        Camera camera = cameraService.createCamera();
        System.out.println(camera);

        DisplayService displayService = abstractFactory.getDisplayService();
        Display display = displayService.createDisplay();
        System.out.println(display);
    }
}