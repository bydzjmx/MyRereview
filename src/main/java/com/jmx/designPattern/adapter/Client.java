package com.jmx.designPattern.adapter;

/**
 * 适配器模式，将一个类的接口转换为客户希望的另一个接口。
 * 一个典型的事例：笔记本没有PS2接口，只有USB接口，要使用PS2接口的键盘打字，需要转换器
 * 该例子中：引出适配器模式的三个角色；
 * 1. 目标接口（Target）： 客户端所期待（调用）的接口。 此处指USB接口
 * 2. 需要适配的类（Adaptee）；需要适配的类或对象，此处指PS2接口的键盘
 * 3. 适配器（Adapter）： 通过包装Adaptee，将原接口转换为目标接口
 * Client类，作为调用方，调用Target接口
 */
public class Client {
    //调用Target接口的方法，实现需求
    public void test(Target target){
        target.handleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        client.test(adapter);
    }
}
