package com.jmx.designPattern.factory.abstractFactory;

/**
 * 抽象工厂的方法，用于创建产品族
 * 创建发动机，座椅和轮胎
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Type createType();
}
