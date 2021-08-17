package com.designMode.agent;

import structure.agent.DemoService;
import structure.agent.DemoServiceImpl;
import structure.agent.cglib.DemoCglibInterceptor;
import structure.agent.cglib.DemoCglibService;
import structure.agent.dynamic.DemoProxyFactory;
import structure.agent.project.ToolService;
import structure.agent.project.ToolProxyFactory;
import structure.agent.project.ToolProxyCallback;
import structure.agent.statics.DemoServiceProxy;
import net.sf.cglib.proxy.Callback;
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
        DemoCglibService serviceProxy2 = (DemoCglibService) structure.agent.cglib.DemoProxyFactory.getProxyInstance(service,cglibInterceptor);
        serviceProxy2.run();
    }

    @Test
    public void testProjectProxy() {

        ToolService service = new ToolService();
        Callback toolProxyCallback = new ToolProxyCallback(service);

        ToolService serviceProxy = (ToolService)ToolProxyFactory.getProxyInstance(service,toolProxyCallback);

        /**
         * 使用 ToolProxyFactory 构建出 ToolCglibService的代理子类，通过代理子类去调用接口方法
         */
        String[] args = new String[]{"-s","test","-n","zhangsan"};

        serviceProxy.run(args);
        // TODO 将代理类丢到缓存中（map)，调用xxx.method时自动代理，通过统一的网关处理，通过cmd区分调用哪个方法；
        //  其实类似if-else之类的，或者用map将cmd和method的关系存起来，然后调用的时候自动代理；
    }
}
