package structure.adapter.clazz;

import java.util.List;

/**
 * 类适配器，定义适配类的方法
 */
public interface SmsIAdaptor {

    // 单发
    void sendSms(String mobile,String content);

    // 群发
    void sendSms(List<String> mobileList, String content);

}
