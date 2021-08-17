package structure.agent.project.anno;

import java.lang.annotation.*;

/**
 * order 值越小 表示优先级越高
 * -1 为默认值，可表示系统拦截
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {

    int value() default -1;
}
