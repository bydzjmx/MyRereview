package com.jmx.designPattern.factory.application.pay;

/**
 * 实际调用,使用工厂，通过传递类型信息来获取实体类的对象
 */
public class Test {
    public static void main(String[] args) {
        PaymentMethod ali = PayFactory.getPayment("ali");
        ali.play();
    }
}
