package behavior.strategy;

public class DiscountStrategy implements Strategy {

    @Override
    public Object discount() {

        System.out.println("打折");
        return null;
    }
}
