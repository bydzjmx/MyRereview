package com.jmx.designPattern.factory.application.pay;

/**
 * 支付方法，不同的支付方式都需要实现该接口
 * 简单工厂模式的三大角色：
 * 1. 工厂
 * 2, 抽象产品角色
 * 3. 实体产品角色
 */
public interface PaymentMethod {
    void play();
}
