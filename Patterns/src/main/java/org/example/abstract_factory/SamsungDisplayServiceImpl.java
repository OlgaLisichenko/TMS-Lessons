package org.example.abstract_factory;

public class SamsungDisplayServiceImpl implements DisplayService {
    @Override
    public Display createDisplay() {
        return new Display("Samsung display");
    }
}