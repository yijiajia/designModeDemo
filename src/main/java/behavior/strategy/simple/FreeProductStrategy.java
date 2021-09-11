package behavior.strategy.simple;

public class FreeProductStrategy implements Strategy {

    @Override
    public Object discount() {
        System.out.println("赠送产品");
        return null;
    }
}
