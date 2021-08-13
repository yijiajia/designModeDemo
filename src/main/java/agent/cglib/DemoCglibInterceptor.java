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


    /**
     * 拦截的实现
     * @param o cglib 生成的代理类实例
     * @param method 目标对象所调用的方法引用
     * @param args 参数列表
     * @param methodProxy   生成的代理类对方法的代理引用
     * @return 方法返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理对象方法执行。");
        long startTime = System.currentTimeMillis();
        // 执行目标对象
        Object obj = method.invoke(target,args);
        // 也可以使用代理对象调用，因为生成的是子类代理，所以要执行父类的方法
        // obj = methodProxy.invokeSuper(target,args);
        // 记录耗时
        long endTime = System.currentTimeMillis();
        System.out.println("方法返回值：obj="+obj);
        System.out.println("方法执行结束。耗时：" + (endTime - startTime) + "ms");
        return obj;
    }
}
