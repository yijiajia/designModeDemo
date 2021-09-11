package behavior.chain.listChain;

public class PoliticsSensitiveWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(String content) {
        boolean isLegal = content.contains("政治");
        System.out.println("政治敏感词过滤");
        return isLegal;
    }
}
