package com.designMode.agent;

import org.junit.Test;
import structure.adapter.SmsWay;
import structure.adapter.clazz.SmsFactory;
import structure.adapter.clazz.SmsIAdaptor;
import structure.adapter.origin.SmsForAli;
import structure.adapter.origin.SmsForWangyi;

import java.util.Arrays;

public class AdapterTest {

    /**
     * 原生方法测试
     */
    @Test
    public void testSmsOrigin() {

        // 使用阿里的发送短信
        SmsForAli smsForAli = new SmsForAli();
        smsForAli.sendSms("123456","hahaha");

        // 使用网易的发生短信
        SmsForWangyi smsForWangyi = new SmsForWangyi();
        smsForWangyi.sendSms(Arrays.asList("123456"),"hahahha");
    }

    /**
     * 类适配器测试
     */
    @Test
    public void testSmsAdaptorForClazz() {

        // 使用阿里适配器发送短信
        SmsIAdaptor smsIAdaptor = SmsFactory.getSmsAdaptor(SmsWay.ALi);
        smsIAdaptor.sendSms("123456","阿里通道发生短信");

        // 使用网易通道发生短信
        smsIAdaptor = SmsFactory.getSmsAdaptor(SmsWay.WANG_YI);
        smsIAdaptor.sendSms("123456","网易通道发生短信");

    }

    /**
     * 对象适配器测试
     */
    @Test
    public void testSmsAdaptorForObject() {
        // 使用阿里适配器发送短信
        SmsIAdaptor smsIAdaptor = structure.adapter.object.SmsFactory.getSmsAdaptor(SmsWay.ALi);
        smsIAdaptor.sendSms("123456","阿里通道发生短信");

        // 使用网易通道发生短信
        smsIAdaptor =  structure.adapter.object.SmsFactory.getSmsAdaptor(SmsWay.WANG_YI);
        smsIAdaptor.sendSms("123456","网易通道发生短信");
    }
}
