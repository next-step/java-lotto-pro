package step2.argumentresolver;

public interface Resolver {

    boolean canResolve(String source);

    String[] resolve(String source);

}
