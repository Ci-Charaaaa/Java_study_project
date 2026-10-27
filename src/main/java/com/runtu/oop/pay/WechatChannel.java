package com.runtu.oop.pay;

public class WechatChannel extends PaymentChannel {

    public WechatChannel(String appId){
        super(appId);
    }

    public String channelName(String name){
        return "Wechat";
    };

    public double feeRate(){
        return 0.005;
    };

    public String pay(double amount){
        /*
        此处调用逻辑先略
        */
        return "1234567890"; //模拟流水号
    };

}
