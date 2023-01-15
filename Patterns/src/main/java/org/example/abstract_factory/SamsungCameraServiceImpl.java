package org.example.abstract_factory;

public class SamsungCameraServiceImpl implements CameraService {
    @Override
    public Camera createCamera() {
        return new Camera("Samsung camera");
    }
}