package structure.adapter.clazz;

import structure.adapter.origin.SmsForWangyi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 网易短信的适配·
 */
public class SmsWangyiAdaptor extends SmsForWangyi implements SmsIAdaptor {

    @Override
    public void sendSms(String mobile, String content) {
        this.sendSms(Collections.singletonList(mobile),content);
    }

    @Override
    public void sendSms(List<String> mobileList, String content) {
        System.out.println("开始适配");
        super.sendSms(mobileList,content);
    }
}
