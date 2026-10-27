package com.runtu.oop.pay;

public abstract class PaymentChannel {

    protected PaymentChannel(String appId){};

    public abstract String channelName(String name);

    public abstract double feeRate();

    public abstract String pay(double amount);

    public boolean refund(String orderNo){
        /*
         根据订单编号查询能否退款
        */
        return true; //假设成功，模拟返回一个真
    }

    public void log(String msg){
        /*
        打印日志
        */
    }
}

interface PaymentChannelInterface {

    public abstract String channelName(String name);

    public abstract double feeRate();

    public abstract String pay(double amount);

    public default boolean refund(String orderNo){
        /*
         根据订单编号查询能否退款
        */
        return true; //假设成功，模拟返回一个真
    }

    public default void log(String msg){
        /*
        打印日志
        */
    }
}
