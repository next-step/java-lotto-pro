package step2.ArgumentResolver;

public class EmptyStringResolver implements Resolver {

    @Override
    public boolean canResolve(String source) {
        return source == null || source.trim().equals("");

    }

    @Override
    public String[] resolve(String source) {
        return new String[]{"0"};
    }
}
