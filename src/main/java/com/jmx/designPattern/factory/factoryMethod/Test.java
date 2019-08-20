package com.jmx.designPattern.factory.factoryMethod;

public class Test {

    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        Car byd = new BydFactory().createCar();
        audi.run();
        byd.run();
    }
}
