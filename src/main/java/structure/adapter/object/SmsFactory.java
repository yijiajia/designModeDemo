package structure.adapter.object;

import structure.adapter.SmsWay;
import structure.adapter.clazz.SmsIAdaptor;
import structure.adapter.origin.SmsForAli;
import structure.adapter.origin.SmsForWangyi;

public class SmsFactory {


    public static SmsIAdaptor getSmsAdaptor(SmsWay smsWay) {
        switch (smsWay) {
            case ALi:
                return new SmsAliAdaptor(new SmsForAli());
            case WANG_YI:
                return new SmsWangyiAdaptor(new SmsForWangyi());
            default:
                throw new RuntimeException("error");
        }
    }
}
