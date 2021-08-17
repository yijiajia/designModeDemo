package structure.agent.project;

import java.util.Arrays;

/**
 * 真正运行的服务
 */
public class ToolService {

    public void run(String[] args) {
        System.out.println("执行目标对象方法;args="+ Arrays.toString(args));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
