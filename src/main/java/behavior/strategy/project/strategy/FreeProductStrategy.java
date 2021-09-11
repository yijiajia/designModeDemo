package behavior.strategy.project.strategy;

import behavior.strategy.project.Strategy;
import behavior.strategy.project.app.ResultDef;

/**
 * 赠送产品策略
 * 买n送n，买m送n
 */
public class FreeProductStrategy implements Strategy {

    @Override
    public ResultDef discount() {
        System.out.println("赠送产品");
        return null;
    }
}
