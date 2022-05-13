package step2.argumentresolver;

public interface StringArrayResolver {

    boolean canResolve(String source);

    String[] resolve(String source);

}
