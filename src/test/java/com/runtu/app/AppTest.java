package com.runtu.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runtu.W1D2.Wallet;
import com.runtu.oop.pay.AlipayChannel;
import com.runtu.oop.pay.PaymentChannel;
import com.runtu.oop.pay.WechatChannel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {



    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //短期测试
    @Test
    public void Test() {
        Wallet wallet = new Wallet();
        test(wallet);
        System.out.println(wallet.getRecords());
    }


    public void test(Wallet wallet) {
        wallet.getRecords().add("伪造的记录");   // 绕过了 Wallet 的所有校验

    }







    void payAll(List<PaymentChannel> channels, double amount){

        double[] fee = {0};
        channels = List.of(new AlipayChannel(""),new WechatChannel(""));
        channels.forEach(channel -> {
            channel.pay(amount);
            fee[0] += amount * (channel.feeRate());
        });

        System.out.println(fee[0]);
    }







}
