package behavior.chain.listChain;

import java.util.LinkedList;
import java.util.List;

public class SensitiveWordFilterChain implements FilterChain {

    // 数组保存链处理器
    private List<SensitiveWordFilter> filters = new LinkedList<>();

    public void addFilter(SensitiveWordFilter filter) {
        filters.add(filter);
    }

    /**
     * 遍历过滤器都执行一遍
     * @param content 校验的内容
     */
    public boolean doChain(String content) {
        for(SensitiveWordFilter filter : filters) {
            if(filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }

}
