package agent.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * 代理工厂
 */
public class DemoProxyFactory {

    /**
     * 获取子类代理对象实例
     * @param target  目标对象
     * @param callback 实现了 MethodInterceptor 的子类
     * @return
     */
    public static Object getProxyInstance(Object target, Callback callback) {
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数。
        enhancer.setCallback(callback);

        return enhancer.create();   // 创建子类代理对象
    }
}
