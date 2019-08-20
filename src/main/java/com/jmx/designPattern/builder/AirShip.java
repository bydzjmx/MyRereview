package com.jmx.designPattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 建造者模式，将创建和装配过程分离（builder &  director），注重创建的过程，不同的builder和director，可以创建不同对象
 * 使用建造者模式创建自己的宇宙飞船，有三个属性，轨道舱，发动机，逃逸塔
 * 1. 创建builder
 * 2. 创建director
 * 3. 使用director创建airship
 */
@Data
public class AirShip {
    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public void showEngine(){
        System.out.println("我是飞船，拥有发动机"+engine.getName());
    }
}

@Data
@AllArgsConstructor
class OrbitalModule{
    private String name;
}

@Data
@AllArgsConstructor
class Engine{
    private String name;
}

@Data
@AllArgsConstructor
class EscapeTower{
    private String name;
}
