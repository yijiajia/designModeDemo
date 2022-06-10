package structure.adapter.origin;

/**
 * 阿里的短信通道
 */
public class SmsForAli {

    public void sendSms(String mobile,String content) {
        System.out.println("发生短信，调用阿里的接口，mobile=" +mobile);
    }

}
