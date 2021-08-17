package behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 无状态的策略工厂
 * 无状态指的是纯算法，不需要每次调用都创建一个新的Strategy
 */
public class StrategyFactory {

    private static final Map<DiscountEnum,Strategy> strategies = new HashMap<>();

    static {
        strategies.put(DiscountEnum.DISCOUNT,new DiscountStrategy());
        strategies.put(DiscountEnum.REDUCE_PRICE,new ReducePriceStrategy());
        strategies.put(DiscountEnum.FREE_COUPON,new FreeCouponStrategy());
        strategies.put(DiscountEnum.FREE_PRODUCT,new FreeProductStrategy());
    }

    /**
     * 获取具体的实现策略
     * @param discountEnum
     * @return
     */
    public static Strategy getStrategy(DiscountEnum discountEnum) {
        if(discountEnum == null) {
            throw new IllegalArgumentException("discountNum should not be null");
        }
        return strategies.get(discountEnum);
    }

}
