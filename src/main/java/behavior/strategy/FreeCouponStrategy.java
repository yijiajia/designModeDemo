package behavior.strategy;

public class FreeCouponStrategy implements Strategy {
    @Override
    public Object discount() {
        System.out.println("赠送优惠券");
        return null;
    }
}
