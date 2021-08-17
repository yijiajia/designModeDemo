package structure.agent.project;

import structure.agent.project.scanner.AnnotationScanner;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class ToolProxyFactory {

    static {
        AnnotationScanner.registerToolInterceptorList();
    }

    /**
     * 获取子类代理实例
     * @param target 目标对象
     * @param callback 回调接口
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
