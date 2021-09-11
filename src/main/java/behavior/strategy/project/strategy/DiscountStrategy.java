package behavior.strategy.project.strategy;


import behavior.strategy.project.Strategy;
import behavior.strategy.project.app.ResultDef;

/**
 * 打折优惠
 * 满x元打n折；
 * 联合购买a+b产品打n折；
 */
public class DiscountStrategy implements Strategy {

    @Override
    public ResultDef discount() {

        System.out.println("打折");
        return null;
    }


}
