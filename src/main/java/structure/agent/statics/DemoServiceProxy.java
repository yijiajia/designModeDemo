package structure.agent.statics;

import structure.agent.DemoService;

/**
 * 代理类，维护目标对象，执行业务逻辑 及 调用目标对象方法
 */
public class DemoServiceProxy implements DemoService {

    // 维护目标对象
    private DemoService service;

    public DemoServiceProxy(DemoService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("代理类对象方法执行；" );
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        service.run();

        // 记录耗时
        long endTime = System.currentTimeMillis();
        System.out.println("方法执行结束。耗时：" + (endTime - startTime) + "ms");
    }

}
