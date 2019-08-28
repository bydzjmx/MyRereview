package com.jmx.designPattern.singleton;

import sun.misc.Unsafe;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双重检测锁
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){};

    public DoubleCheckSingleton getInstance(){
        //懒加载
        if(instance==null){
            //检测锁
            synchronized (DoubleCheckSingleton.class){
                if(instance==null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
