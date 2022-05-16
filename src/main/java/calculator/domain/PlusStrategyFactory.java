package calculator.domain;

import calculator.exception.ExceptionType;

public class PlusStrategyFactory {
    public PlusStrategy getStrategy(String expressionStr) {
        if (ExpressionUtils.isEmptyExpression(expressionStr)) {
            return new EmptyPlusStrategy();
        }

        if (ExpressionUtils.isSingleNumberExpression(expressionStr)) {
            return new SingleNumberPlusStrategy();
        }

        if (ExpressionUtils.isDefaultExpression(expressionStr)) {
            return new DefaultDelimiterPlusStrategy();
        }

        if (ExpressionUtils.isCustomExpression(expressionStr)) {
            return new CustomDelimiterPlusStrategy();
        }

        throw new IllegalArgumentException(ExceptionType.INVALID_EXPRESSION.getMessage());
    }
}
