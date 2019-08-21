package com.jmx.designPattern.adapter;

/**
 * 适配器，适配Target接口和Adaptee
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        //调用被适配类的方法
        adaptee.request();
    }
}
