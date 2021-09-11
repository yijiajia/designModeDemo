package behavior.strategy.project.strategy;

import behavior.strategy.project.Strategy;
import behavior.strategy.project.app.ResultDef;

/**
 * 赠送优惠券策略
 * 买 a 产品赠送 n张优惠券；
 */
public class FreeCouponStrategy implements Strategy {
    @Override
    public ResultDef discount() {
        System.out.println("赠送优惠券");
        return null;
    }
}
