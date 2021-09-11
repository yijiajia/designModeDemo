package behavior.strategy.project;

import behavior.strategy.project.app.ResultDef;

/**
 * 策略接口
 */
public interface Strategy {
    /**
     * 优惠策略
     */
    ResultDef discount() throws Exception;

}
