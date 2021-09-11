package behavior.strategy.project.strategy;

import behavior.strategy.project.Strategy;
import behavior.strategy.project.app.ResultDef;

/**
 * 减价优惠
 * 满 m 减 n
 */
public class ReducePriceStrategy implements Strategy {

    @Override
    public ResultDef discount() {
        System.out.println("减价");
        return null;
    }
}
