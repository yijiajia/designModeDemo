package behavior.strategy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 有状态的策略工厂
 */
public class StrategyFactory2 {

    private static final Map<DiscountEnum,Class<? extends Strategy>> strategies = new HashMap<>();

    static {
        strategies.put(DiscountEnum.DISCOUNT, DiscountStrategy.class);
        strategies.put(DiscountEnum.REDUCE_PRICE, ReducePriceStrategy.class);
        strategies.put(DiscountEnum.FREE_COUPON, FreeCouponStrategy.class);
        strategies.put(DiscountEnum.FREE_PRODUCT, FreeProductStrategy.class);
    }

    /**
     * 每一次获取都重新创建一个 Strategy
     */
    public static Strategy getStrategy(DiscountEnum discountEnum) throws InstantiationException, IllegalAccessException {
        if(discountEnum == null) {
            throw new IllegalArgumentException("discountNum should not be null");
        }

        Class<? extends Strategy> strategyClass = strategies.get(discountEnum);
        return strategyClass.newInstance();
    }

}
