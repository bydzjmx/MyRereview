package com.jmx.designPattern.factory.factoryMethod;

public class AudiFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Audi();
    }
}
