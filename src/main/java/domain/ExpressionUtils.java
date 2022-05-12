package domain;

import java.util.regex.Pattern;

public class ExpressionUtils {
    public static final String SINGLE_NUMBER_REGEX = "[0-9]";
    public static final String DEFAULT_REGEX = "^(((\\d)(\\,|:))+\\d$)";
    public static final String CUSTOM_REGEX = "//(.)\\n(.*)";

    public static boolean isEmptyExpression(String expressionStr) {
        return expressionStr == null || expressionStr.isEmpty();
    }

    public static boolean isSingleNumberExpression(String expressionStr) {
        return Pattern.matches(SINGLE_NUMBER_REGEX, expressionStr);
    }

    public static boolean isDefaultExpression(String expressionStr) {
        return Pattern.matches(DEFAULT_REGEX , expressionStr);
    }

    public static boolean isCustomExpression(String expressionStr) {
        return Pattern.compile(CUSTOM_REGEX).matcher(expressionStr).find();
    }
}
