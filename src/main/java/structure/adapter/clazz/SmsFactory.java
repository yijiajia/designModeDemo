package structure.adapter.clazz;

import structure.adapter.SmsWay;

/**
 * 短信工厂
 */
public class SmsFactory {


    public static SmsIAdaptor getSmsAdaptor(SmsWay smsWay) {
        switch (smsWay) {
            case ALi:
                return new SmsAliAdaptor();
            case WANG_YI:
                return new SmsWangyiAdaptor();
            default:
                throw new RuntimeException("way error");
        }
    }

}
