package com.jmx.designPattern.adapter;

/**
 * 需要被适配的类
 */
public class Adaptee {

    /**
     * 被适配类的方法
     */
    public void request(){
        System.out.println("可以完成客户端所需要的功能");
    }
}
