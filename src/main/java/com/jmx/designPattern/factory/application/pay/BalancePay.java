package com.jmx.designPattern.factory.application.pay;

public class BalancePay implements PaymentMethod {
    @Override
    public void play() {
        System.out.println("余额支付");
    }
}
