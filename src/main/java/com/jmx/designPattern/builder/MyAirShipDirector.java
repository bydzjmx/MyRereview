package com.jmx.designPattern.builder;

/**
 * Director实现类，用于实现自己的director逻辑
 */
public class MyAirShipDirector implements AirShipDirector {
    private AirShipBuilder airShipBuilder;

    //传入构建者的零件的信息
    public MyAirShipDirector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    @Override
    public AirShip buildAirship() {
        AirShip airShip = new AirShip();
        //创建三个组件
        Engine engine = airShipBuilder.createEngine();
        EscapeTower escapeTower = airShipBuilder.createEscapeTower();
        OrbitalModule orbitalModule = airShipBuilder.createOrbitalModule();

        //设置
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);
        return airShip;
    }
}
