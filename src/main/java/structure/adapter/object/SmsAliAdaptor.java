package structure.adapter.object;

import structure.adapter.clazz.SmsIAdaptor;
import structure.adapter.origin.SmsForAli;

import java.util.List;

public class SmsAliAdaptor implements SmsIAdaptor {

    private SmsForAli smsForAli;

    public SmsAliAdaptor(SmsForAli smsForAli) {
        this.smsForAli = smsForAli;
    }

    @Override
    public void sendSms(String mobile, String content) {
        smsForAli.sendSms(mobile,content);
    }

    @Override
    public void sendSms(List<String> mobileList, String content) {
        for (String mobile : mobileList) {
            smsForAli.sendSms(mobile,content);
        }
    }
}
