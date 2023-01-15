package org.example.abstract_factory;

public class AppleCameraServiceImpl implements CameraService {
    @Override
    public Camera createCamera() {
        return new Camera("Apple camera");
    }
}