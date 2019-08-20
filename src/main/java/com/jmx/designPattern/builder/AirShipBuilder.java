package com.jmx.designPattern.builder;

/**
 * 飞船的构建类builder
 *  负责构建三个子组件，然后供装配者director装配成一个完整的飞船
 */
public interface AirShipBuilder {
    OrbitalModule createOrbitalModule();
    Engine createEngine();
    EscapeTower createEscapeTower();
}
