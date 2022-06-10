package structure.adapter.clazz;

import structure.adapter.origin.SmsForAli;

import java.util.List;

/**
 * 阿里短信的适配器
 */
public class SmsAliAdaptor extends SmsForAli implements SmsIAdaptor {

    @Override
    public void sendSms(String mobile, String content) {
        System.out.println("开始适配，调用父类方法");
        super.sendSms(mobile, content);
    }

    @Override
    public void sendSms(List<String> mobileList, String content) {
        for(String mobile : mobileList) {
            sendSms(mobile,content);
        }
    }
}
