package behavior.strategy.simple;

public class ReducePriceStrategy implements Strategy {

    @Override
    public Object discount() {
        System.out.println("减价");
        return null;
    }
}
