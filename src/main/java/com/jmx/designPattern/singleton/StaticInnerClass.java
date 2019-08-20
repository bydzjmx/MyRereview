package com.jmx.designPattern.singleton;

/**
 * 静态内部类实现单例模式
 * 略过双重检测所，由于JVM底层模型原因，双重检测锁可能存在问题
 * 该方法： 1. 线程安全。类 的加载过程是天然的线程安全的
 * 2. 实现延时加载，只有调用getInstance才会去加载内部类
 * 3. 直接调用，不需要同步等待。并发调用效率高
 */
public class StaticInnerClass {

    //定义内部类
    private static class SingletonClassInstance{
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    //构造器私有
    private StaticInnerClass(){};

    //提供调用方法
    public StaticInnerClass getInstance(){
        return SingletonClassInstance.instance;
    }
}
