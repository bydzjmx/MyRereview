package com.jmx.designPattern.builder;

/**
 * Builder实现类，用于实现自己的建造逻辑
 */
public class MyAirShipBuilder implements AirShipBuilder {

    @Override
    public OrbitalModule createOrbitalModule() {
        System.out.println("创建轨道舱");
        return new OrbitalModule("我的轨道舱");
    }

    @Override
    public Engine createEngine() {
        System.out.println("创建发动机");
        return new Engine("我的发动机");
    }

    @Override
    public EscapeTower createEscapeTower() {
        System.out.println("创建逃逸塔");
        return new EscapeTower("我的逃逸塔");
    }
}
