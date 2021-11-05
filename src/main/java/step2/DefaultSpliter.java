package step2;

public class DefaultSpliter implements Spliter{
    private final String inputValue;
    private final String DELEMITER = ",|:";

    public DefaultSpliter(String inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String[] split() {
        return  inputValue.split(DELEMITER);
    }
}
