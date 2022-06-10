package structure.adapter.origin;

import java.util.List;

public class SmsForWangyi {

    public void sendSms(List<String> mobileList, String content) {
        System.out.println("发生短信，调用网易的发送接口，content=" +content);
    }
}
