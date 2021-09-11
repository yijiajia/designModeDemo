package behavior.chain.nextHandler;

public class HandlerB extends Handler{

    @Override
    public boolean doHandle() {
        System.out.println("run Handler b");
        return false;
    }
}
