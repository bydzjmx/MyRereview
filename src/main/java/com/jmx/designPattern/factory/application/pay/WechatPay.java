package com.jmx.designPattern.factory.application.pay;

public class WechatPay implements PaymentMethod {
    @Override
    public void play() {
        System.out.println("微信支付");
    }
}
