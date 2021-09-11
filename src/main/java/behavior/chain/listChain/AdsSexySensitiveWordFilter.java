package behavior.chain.listChain;

public class AdsSexySensitiveWordFilter implements SensitiveWordFilter{

    @Override
    public boolean doFilter(String content) {
        System.out.println("广告词过滤");
        return content.contains("广告");
    }
}
