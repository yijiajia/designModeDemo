package behavior.chain.nextHandler;

public class HandlerChain {

    private Handler head;
    private Handler tail;

    public void setNext(Handler handler) {
        handler.setNext(null);

        if(head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setNext(handler);
        tail = handler;
    }

    public void handle() {
        if(head != null) {
            head.handle();
        }
    }

}
