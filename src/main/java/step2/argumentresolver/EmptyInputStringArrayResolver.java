package step2.argumentresolver;

public class EmptyInputStringArrayResolver implements StringArrayResolver {

    @Override
    public boolean canResolve(String source) {
        return source == null || source.trim().equals("");

    }

    @Override
    public String[] resolve(String source) {
        return new String[]{"0"};
    }
}
