package domain;

import exception.ExceptionType;

public class PlusStrategyFactory {
    public PlusStrategy getStrategy(String expressionStr) {
        if (ExpressionUtils.isEmptyExpression(expressionStr)) {
            return new EmptyPlusStrategy();
        }

        if (ExpressionUtils.isSingleNumberExpression(expressionStr)) {
            return new SingleNumberPlusStrategy();
        }

        throw new RuntimeException(ExceptionType.INVALID_EXPRESSION.getMessage());
    }
}
