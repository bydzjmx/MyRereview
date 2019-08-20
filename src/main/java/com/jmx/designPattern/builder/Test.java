package com.jmx.designPattern.builder;

/**
 * 测试建造者模式
 */
public class Test {
    public static void main(String[] args) {
        //获取director创建飞船
        MyAirShipDirector director = new MyAirShipDirector(new MyAirShipBuilder());
        //使用director建造宇宙飞船
        AirShip airShip = director.buildAirship();
        //打印宇宙飞船的发动机类型
        System.out.println(airShip.getEngine());
        //展示飞船发动机类型
        airShip.showEngine();
    }
}
