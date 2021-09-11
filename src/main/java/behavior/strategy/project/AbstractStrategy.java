package behavior.strategy.project;

import behavior.strategy.project.app.ResultDef;

/**
 *
 */
public abstract class AbstractStrategy implements Strategy {

    @Override
    public ResultDef discount() throws Exception {



        return null;
    }

    /**
     * 是否满足条件
     * @return
     */
    public abstract boolean isMeetCondition();

}
