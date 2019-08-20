package com.jmx.designPattern.factory.abstractFactory;

/**
 * 轮胎组件
 */
public interface Type {
    void run();
}

class LuxuryType implements Type{

    @Override
    public void run() {
        System.out.println("高端轮胎");
    }
}

class LowType implements Type{

    @Override
    public void run() {
        System.out.println("低端轮胎");
    }
}
