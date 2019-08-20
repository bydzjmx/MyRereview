package com.jmx.designPattern.factory.abstractFactory;

/**
 * 豪华工厂，通过豪华工厂的产品族生成
 */
public class LuxuryFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Type createType() {
        return new LuxuryType();
    }
}
