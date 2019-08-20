package com.jmx.designPattern.factory.simpleFactory;

/**
 * 定义简单工厂方法。直接通过工厂进行实例的创建和调用
 * 便于管理，将创建和调用进行分离，也方便进行扩展
 */
public class CarFactory {
    //定义创建方法
    public static Car createCar(String type){
        if("audi".equals(type)){
            return new Audi();
        }else if("byd".equals(type)){
            return new Byd();
        }else {
            return null;
        }
    }
}
