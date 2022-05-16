package calculator.domain;

public class SingleNumberPlusStrategy implements PlusStrategy {
    @Override
    public int result(String expressionStr) {
        return Integer.parseInt(expressionStr);
    }
}
