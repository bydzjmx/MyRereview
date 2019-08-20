package com.jmx.designPattern.factory.factoryMethod;

public class BydFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Byd();
    }
}
