package structure.agent;

public class DemoServiceImpl implements DemoService{

    @Override
    public void run() {
        System.out.println("执行目标对象的方法。");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
