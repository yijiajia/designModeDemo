package com.designMode.agent;

import agent.DemoService;
import agent.DemoServiceImpl;
import agent.cglib.DemoCglibInterceptor;
import agent.cglib.DemoCglibService;
import agent.dynamic.DemoProxyFactory;
import agent.statics.DemoServiceProxy;
import org.junit.Test;

/**
 * 代理测试
 */
public class ProxyTest {


    /**
     * 静态代理的实现
     */
    @Test
    public void testStaticsProxy() {
        // 目标对象
        DemoService service = new DemoServiceImpl();
        // 代理对象,把目标对象传给代理对象,建立代理关系
        DemoService serviceProxy = new DemoServiceProxy(service);
        // 执行方法
        serviceProxy.run();
    }

    /**
     * 动态代理，jdk自带的实现
     */
    @Test
    public void testDynamicProxy() {
        DemoService service = new DemoServiceImpl();    // 目标对象
        DemoProxyFactory factory = new DemoProxyFactory(service);   // 构建代理工厂

        DemoService serviceProxy  = (DemoService)factory.getProxyInstance(); // 通过代理工厂获取代理类
        serviceProxy.run();
    }

    /**
     * 动态代理，cglib的实现
     */
    @Test
    public void testCglibProxy() {
        System.out.println("方法一：使用方法拦截对象的方法获取代理对象");
        DemoCglibService service = new DemoCglibService();
        DemoCglibInterceptor cglibInterceptor = new DemoCglibInterceptor(service);

        DemoCglibService serviceProxy = (DemoCglibService) cglibInterceptor.getProxyInstance();
        serviceProxy.run();

        System.out.println("\n");

        System.out.println("方法二：使用代理工厂获取子类代理对象");
        DemoCglibService serviceProxy2 = (DemoCglibService) agent.cglib.DemoProxyFactory.getProxyInstance(service,cglibInterceptor);
        serviceProxy2.run();
    }
}
