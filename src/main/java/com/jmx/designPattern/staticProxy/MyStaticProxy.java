package com.jmx.designPattern.staticProxy;

/**
 * 静态代理类
 * 所谓代理模式，就是通过代理方来操作目标对象，而不是自己直接调用。
 * 将实际对象通过构造函数的形式注入代理类，代理类可以直接操作目标对象
 */
public class MyStaticProxy implements MobilePhone{
    private MobilePhone amp;

    public MyStaticProxy(MobilePhone amp){
        this.amp = amp;
    }

    @Override
    public void callJack() {
        System.out.println("--静态代理前置--");
        amp.callJack();
        System.out.println("--静态代理后置--");
    }
}
