package com.jmx.designPattern.factory.abstractFactory;

/**
 * 发动机组件
 */
public interface Engine {
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void start() {
        System.out.println("高端发动机");
    }
}
class LowEngine implements Engine{

    @Override
    public void start() {
        System.out.println("低端发动机");
    }
}
