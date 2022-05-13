package step2.argumentresolver;

public class SingleNumberStringArrayResolver implements StringArrayResolver {

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
