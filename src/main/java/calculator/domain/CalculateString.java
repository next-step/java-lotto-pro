package calculator.domain;

public class CalculateString {
    private String expression;

    private CalculateString(){}

    public static CalculateString create(String input) {
        CalculateString calculateString = new CalculateString();
        calculateString.expression = input;

        return calculateString;
    }

    public boolean isNull() {
        return expression == null;
    }

    public boolean isEmpty() {
        return expression.isEmpty();
    }

    public String getExpression() {
        return expression;
    }
}
