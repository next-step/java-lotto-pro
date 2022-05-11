package domain;

import exception.ExceptionType;

public class PlusStrategyFactory {
    public PlusStrategy getStrategy(String expressionStr) {
        if (ExpressionUtils.isEmptyExpression(expressionStr)) {
            return new EmptyPlusStrategy();
        }

        throw new RuntimeException(ExceptionType.INVALID_EXPRESSION.getMessage());
    }
}
