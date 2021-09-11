package behavior.chain.listChain;

public class SexySensitiveWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(String content) {
        System.out.println("过滤黄色敏感词");
        return content.contains("黄色");
    }
}
