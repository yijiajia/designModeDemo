package behavior.chain.listChain;

/**
 * 敏感词 过滤器
 */
public interface SensitiveWordFilter {

    boolean doFilter(String content);

}
