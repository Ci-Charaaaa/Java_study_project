package com.runtu.oop.pay;

public class AlipayChannel extends PaymentChannel implements PaymentChannelInterface {

    public AlipayChannel(String appId){
        super(appId);
    }

    public String channelName(String name){
        return "Alipay";
    };

    public double feeRate(){
        return 0.003;
    };

    public String pay(double amount){
        /*
        此处调用逻辑先略
        可以调用碰一碰付款或者正常付款
        */
        return "0987654321"; //模拟流水号
    };

    public void pengyipeng(double amount){
        /*
        使用碰一碰付款
        */
    }
}
