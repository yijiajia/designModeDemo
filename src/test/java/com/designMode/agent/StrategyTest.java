package com.designMode.agent;

import behavior.strategy.simple.DiscountEnum;
import behavior.strategy.simple.DiscountStrategy;
import behavior.strategy.simple.Strategy;
import behavior.strategy.simple.StrategyFactory;
import org.junit.Test;

public class StrategyTest {

    /**
     * 运行时动态确定
     */
    @Test
    public void testStrategy() {
        // 假设动态运行时获取的类型为减价类型
        DiscountEnum discountEnum = DiscountEnum.REDUCE_PRICE;
        Strategy strategy = StrategyFactory.getStrategy(discountEnum);
        strategy.discount();
    }

    /***
     * 静态确定策略
     */
    @Test
    public void testStrategy4Static() {
        // 假设知道要使用的算法为减价，直接new对应的策略实例
        Strategy strategy = new DiscountStrategy();
        strategy.discount();
    }
}
