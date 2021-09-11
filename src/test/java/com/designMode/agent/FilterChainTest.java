package com.designMode.agent;

import behavior.chain.listChain.AdsSexySensitiveWordFilter;
import behavior.chain.listChain.PoliticsSensitiveWordFilter;
import behavior.chain.listChain.SensitiveWordFilterChain;
import behavior.chain.listChain.SexySensitiveWordFilter;
import behavior.chain.nextHandler.HandlerA;
import behavior.chain.nextHandler.HandlerB;
import behavior.chain.nextHandler.HandlerChain;
import org.junit.Test;

public class FilterChainTest {

    /***
     * 实现方式：数组保存过滤器
     * 执行目标：其中一条过滤器不满足就停止过滤
     */
    @Test
    public void testChainFilter() {

        String content = "打打杀杀";    // 文章内容

        // 注册过滤器
        SensitiveWordFilterChain chain = new SensitiveWordFilterChain();
        chain.addFilter(new SexySensitiveWordFilter());
        chain.addFilter(new AdsSexySensitiveWordFilter());
        chain.addFilter(new PoliticsSensitiveWordFilter());

        // 执行过滤
        System.out.println(chain.doChain(content));
    }

    @Test
    public void testHandlerChain() {

        // 注册链处理器
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.setNext(new HandlerA());
        handlerChain.setNext(new HandlerB());

        // 执行过滤
        handlerChain.handle();
    }
}
