package behavior.chain;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("创建Filter时调用");
        // FilterConfig 参数从配置文件web.xml中读取
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...拦截客户端发送过来的请求");
        filterChain.doFilter(servletRequest, servletResponse);  // 实际上是个递归过程，一直向下递归，直到底，然后回溯，执行后面的方法
        System.out.println("doFilter...拦截返回给客户端的响应");
    }

    @Override
    public void destroy() {
        System.out.println("销毁Filter时调用");
    }


}
