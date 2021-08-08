package agent.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 */
public class DemoProxyFactory {

    // 目标对象。即被代理类
    private Object target;

    public DemoProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        InvocationHandler handler = new DemoServiceHandler();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),handler);
    }

    class DemoServiceHandler implements InvocationHandler {
        /**
         * 代理执行方法
         * @param proxy  代理对象实例
         * @param method 运行时调用的方法，也即目标对象需要执行的方法
         * @param args  method 方法执行所需要的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理对象方法执行。proxy.class="+proxy.getClass().getCanonicalName());
            long startTime = System.currentTimeMillis();
            // 执行目标对象
            Object obj = method.invoke(target);
            // 记录耗时
            long endTime = System.currentTimeMillis();
            System.out.println("方法执行结束。耗时：" + (endTime - startTime) + "ms");
            return obj;
        }
    }

}
