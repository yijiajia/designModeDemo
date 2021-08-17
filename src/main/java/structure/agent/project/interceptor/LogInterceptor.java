package structure.agent.project.interceptor;

import structure.agent.project.anno.Order;
import structure.agent.project.anno.ToolAspect;

import java.lang.reflect.Method;
import java.util.logging.Logger;

@ToolAspect
@Order(2)
public class LogInterceptor extends AbstractInterceptor {

    private long startTime;

    private long endTime;

    private static Logger logger = Logger.getLogger(LogInterceptor.class.getName());

    @Override
    public void before(Object target, Method method,Object[] args) {
        startTime = System.currentTimeMillis();
        logger.info("代理对象方法执行。参数args="+args);
    }

    @Override
    public void after(Object target,Method method,Object result) {
        endTime = System.currentTimeMillis();
        logger.info("方法执行结束。耗时：" + (endTime - startTime) + "ms");
    }
}
