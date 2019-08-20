package com.jmx.designPattern.factory.application.pay;

/**
 * 支付工厂，传入不同的参数，调用不同的支付方法
 */
public class PayFactory {
    public static PaymentMethod getPayment(String type){
        switch (type){
            case "ali":
                return new Alipay();
            case "wechat":
                return new WechatPay();
            case "balance":
                return new BalancePay();
            default:
                System.out.println("支付方式错误");
        }
        return null;
    }
}
