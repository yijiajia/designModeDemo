package behavior.chain.listChain;

/**
 * 过滤器工厂方法
 */
public class FilterFactory {

    private static SensitiveWordFilterChain sensitiveWordFilterChain = new SensitiveWordFilterChain();

    /**
     * 初始化过滤器执行链
     */
    static {
        // 初始化敏感词执行器链
        initSensitiveWordFilter();

        // 初始化xss、SQL 安全信息执行器链
        initXssSQLFilterChain();
    }


    private static void initSensitiveWordFilter() {
        sensitiveWordFilterChain.addFilter(new SexySensitiveWordFilter());
        sensitiveWordFilterChain.addFilter(new AdsSexySensitiveWordFilter());
        sensitiveWordFilterChain.addFilter(new PoliticsSensitiveWordFilter());
    }

    private static void initXssSQLFilterChain() {
        // init..
    }

    public static FilterChain getFilterChain() {
        // TODO  动态获取执行器链
        return sensitiveWordFilterChain;
    }

}
