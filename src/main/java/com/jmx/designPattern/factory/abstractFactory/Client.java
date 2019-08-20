package com.jmx.designPattern.factory.abstractFactory;

/**
 * 创建产品族，根据工厂来创建
 */
public class Client {
    public static void main(String[] args) {
        //使用不同的工厂进行创建
        LuxuryFactory luxuryFactory = new LuxuryFactory();
        Engine engine = luxuryFactory.createEngine();
        engine.start();

        LowFactory lowFactory = new LowFactory();
        Engine engine1 = lowFactory.createEngine();
        engine1.start();
    }
}
