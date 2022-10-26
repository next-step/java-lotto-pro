package calculator.domain.target.splitter;

public class BasicSplitter implements CalculatorSplitter {

    private static final String SEPARATOR = "[,:]";

    @Override
    public String[] split(String target) {
        return target.split(SEPARATOR);
    }
}
