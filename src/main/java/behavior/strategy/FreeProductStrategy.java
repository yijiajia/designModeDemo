package behavior.strategy;

public class FreeProductStrategy implements Strategy {

    @Override
    public Object discount() {
        System.out.println("赠送产品");
        return null;
    }
}
