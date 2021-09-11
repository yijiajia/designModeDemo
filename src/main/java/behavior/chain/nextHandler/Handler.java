package behavior.chain.nextHandler;

public abstract class Handler {

    protected Handler next = null;

    public void setNext(Handler next) {
        this.next = next;
    }

    public final void handle() {
        boolean handled = doHandle();
        if(next != null && !handled) {  // 自己处理不了就交给下一个链处理器
            next.handle();
        }
    }

    public abstract boolean doHandle();
}
