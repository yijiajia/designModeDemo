package structure.adapter.object;

import structure.adapter.clazz.SmsIAdaptor;
import structure.adapter.origin.SmsForWangyi;

import java.util.Arrays;
import java.util.List;

public class SmsWangyiAdaptor implements SmsIAdaptor {

    private SmsForWangyi smsForWangyi;

    public SmsWangyiAdaptor(SmsForWangyi smsForWangyi) {
        this.smsForWangyi = smsForWangyi;
    }

    @Override
    public void sendSms(String mobile, String content) {
        sendSms(Arrays.asList(mobile),content);
    }

    @Override
    public void sendSms(List<String> mobileList, String content) {
        smsForWangyi.sendSms(mobileList, content);
    }
}
