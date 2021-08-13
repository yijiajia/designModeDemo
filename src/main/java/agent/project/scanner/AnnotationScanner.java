package agent.project.scanner;

import agent.project.anno.Order;
import agent.project.anno.ToolAspect;
import agent.project.interceptor.AbstractInterceptor;
import agent.project.ToolProxyCallback;
import agent.project.utils.ClassUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 注解扫描器
 */
public class AnnotationScanner {

    private static final String packageName = "agent.project";

    /**
     * 自动注册工具拦截器
     */
    public static void registerToolInterceptorList() {

        List<Class> list = ClassUtil.getAllClassByAnnotation(ToolAspect.class,packageName);

        // 从小到大排序
        Collections.sort(list, new Comparator<Class>() {
            @Override
            public int compare(Class clazz1, Class clazz2) {
                Order order1 = (Order)clazz1.getAnnotation(Order.class);
                Order order2 = (Order)clazz2.getAnnotation(Order.class);
                return order1.value() - order2.value();
            }
        });

        for(Class clazz : list) {
            AbstractInterceptor interceptor = null;
            try {
                interceptor = (AbstractInterceptor)clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ToolProxyCallback.registerInterceptor(interceptor);
        }
    }
}
