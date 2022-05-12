package step2.ArgumentResolver;

public interface Resolver {

    boolean canResolve(String source);

    String[] resolve(String source);

}
