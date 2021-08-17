package structure.agent.cglib;

public class DemoCglibService {

    public String run() {
        System.out.println("执行目标对象的方法。");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
