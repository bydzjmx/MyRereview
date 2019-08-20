package com.jmx.designPattern.factory.application.pay;

public class Alipay implements PaymentMethod {
    @Override
    public void play() {
        System.out.println("支付宝支付");
    }
}
