package com.jmx.designPattern.factory.simpleFactory;

public class Test {

    //使用工厂方法创建实例
    public static void main(String[] args) {
        Car audi = CarFactory.createCar("audi");
        Car byd = CarFactory.createCar("byd");
        audi.run();
        byd.run();
    }
}
