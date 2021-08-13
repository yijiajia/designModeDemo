package agent.project.interceptor;


import java.lang.reflect.Method;

public abstract class AbstractInterceptor {

    /**
     * 前置逻辑
     * @param target 目标对象
     * @param method 目标方法
     * @param args  参数
     * @throws Exception
     */
    public abstract void before(Object target, Method method,Object[] args) throws Exception;

    /***
     * 后置逻辑
     * @param target 目标对象
     * @param method 目标方法
     * @param result 处理结果
     * @throws Exception
     */
    public abstract void after(Object target,Method method,Object result) throws Exception;

}
