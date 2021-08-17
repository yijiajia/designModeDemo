package structure.agent.project;

import structure.agent.project.interceptor.AbstractInterceptor;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class ToolProxyCallback implements MethodInterceptor {

   private Object target;

   public ToolProxyCallback(Object target) {
      this.target = target;
   }

   private static List<AbstractInterceptor> interceptorList = new LinkedList<>();

   public static void registerInterceptor(AbstractInterceptor interceptor) {
      interceptorList.add(interceptor);
   }


   @Override
   public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

      for(AbstractInterceptor interceptor : interceptorList) {
         interceptor.before(target,method,args);
      }

      System.out.println("准备执行目标方法；interceptorList.size="+interceptorList.size());
      Object resultObj = method.invoke(target,args);

      for(AbstractInterceptor interceptor : interceptorList) {
         interceptor.after(target,method,resultObj);
      }

      return resultObj;
   }


}
