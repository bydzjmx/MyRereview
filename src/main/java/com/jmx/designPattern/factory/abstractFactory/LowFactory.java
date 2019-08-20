package com.jmx.designPattern.factory.abstractFactory;

/**
 * 普通工厂，根据普通工厂的产品族生成
 */
public class LowFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Type createType() {
        return new LowType();
    }
}
