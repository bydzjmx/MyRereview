package com.jmx.designPattern.factory.abstractFactory;

/**
 * 座椅组件
 */
public interface Seat {
    void massage();
}

class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("高端按摩");
    }
}
class LowSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("低端按摩");
    }
}
