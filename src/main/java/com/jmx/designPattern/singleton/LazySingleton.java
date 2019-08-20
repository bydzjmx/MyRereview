package com.jmx.designPattern.singleton;

/**
 * 懒汉式
 * 加载时没有生成单例，只有在调用getInstance方法时才会去创建单例
 * 优点： 实现延迟加载
 * 缺点： 需要同步等待，并发效率低
 */
public class LazySingleton {

    private LazySingleton(){};

    private static volatile LazySingleton instance = null;

    public synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
