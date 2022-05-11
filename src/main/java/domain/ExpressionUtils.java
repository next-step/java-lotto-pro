package domain;

import java.util.regex.Pattern;

public class ExpressionUtils {
    public static final String SINGLE_NUMBER_REGEX = "[0-9]";

    public static boolean isEmptyExpression(String expressionStr) {
        return expressionStr == null || expressionStr.isEmpty();
    }

    public static boolean isSingleNumberExpression(String expressionStr) {
        return Pattern.matches(SINGLE_NUMBER_REGEX, expressionStr);
    }
}
