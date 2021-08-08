package agent.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoCglibInterceptor implements MethodInterceptor {

    private Object target;

    public DemoCglibInterceptor(Object target) {
        this.target = target;
    }

    /**
     * @return 子类代理对象
     */
    public Object getProxyInstance() {
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数。回调到当前对象（因为当前对象就是callBack的实现
        enhancer.setCallback(this);

        return enhancer.create();   // 创建子类代理对象
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理对象方法执行。");
        long startTime = System.currentTimeMillis();
        // 执行目标对象
        Object obj = method.invoke(target);
        // 记录耗时
        long endTime = System.currentTimeMillis();
        System.out.println("方法执行结束。耗时：" + (endTime - startTime) + "ms");
        return obj;
    }
}
