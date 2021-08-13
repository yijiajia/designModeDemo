package agent.project.interceptor;


import agent.project.anno.Order;
import agent.project.anno.ToolAspect;

import java.lang.reflect.Method;

@ToolAspect
@Order(1)
public class AuthInterceptor extends AbstractInterceptor {
    @Override
    public void before(Object target, Method method, Object[] args) throws Exception {
        System.out.println("run start..."+ this.getClass());
    }

    @Override
    public void after(Object target, Method method, Object result) throws Exception {
        System.out.println("run end..."+this.getClass());
    }
}
