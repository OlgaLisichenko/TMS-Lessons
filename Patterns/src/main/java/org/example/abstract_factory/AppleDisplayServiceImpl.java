package org.example.abstract_factory;

public class AppleDisplayServiceImpl implements DisplayService {
    @Override
    public Display createDisplay() {
        return new Display("Apple display");
    }
}