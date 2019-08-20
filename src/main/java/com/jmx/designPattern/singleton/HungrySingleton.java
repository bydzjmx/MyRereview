package com.jmx.designPattern.singleton;

/**
 * 饿汉式，在类初始化时就创建
 * 1. 不能延时加载，造成资源浪费
 * 2. 线程安全
 */
public class HungrySingleton {
    //构造器私有
    private HungrySingleton() {
    };

    //创建静态对象
    private static final HungrySingleton instance = new HungrySingleton();

    //获取方法
    public static HungrySingleton getInstance(){
        return instance;
    }

}
