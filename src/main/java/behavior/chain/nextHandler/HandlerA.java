package behavior.chain.nextHandler;

public class HandlerA extends Handler {
    @Override
    public boolean doHandle() {
        System.out.println("run Handler a");
        return false;
    }
}
