package step2.ArgumentResolver;

public class InputSingleNumberResolver implements Resolver {

    @Override
    public boolean canResolve(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String[] resolve(String source) {
        return new String[]{source};
    }

}
