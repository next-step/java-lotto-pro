package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String AN_UNACCEPTABLE_VALUE_WAS_ENTERED = "허용되지 않는 값이 입력되었습니다.";

    private static final String UNACCEPTABLE_VALUE = "[a-zA-Z가-힣]+";
    private static final String POSITIVE_INTEGER = "\\d*";
    private static final String NEGATIVE_INTEGER = "-\\d*";
    private static final String NORMAL_SPLIT = ",|:";
    private static final String CUSTOM_SPLIT = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isNotNull(input)) {
            validateInputString(input);
        }

        if (isNull(input) || isEmpty(input)) {
            return 0;
        }

        if (isPositiveInteger(input)) {
            return readInt(input);
        }

        if (isCustomInputString(input)) {
            return customSplitAndSum(input);
        }

        return normalSplitAndSum(input);
    }

    public static int readInt(String input) {
        return Integer.parseInt(input);
    }

    public static void validateInputString(String input) {
        if (isUnacceptableValue(input) || isNegativeInteger(input)) {
            throw new RuntimeException(AN_UNACCEPTABLE_VALUE_WAS_ENTERED);
        }
    }

    public static boolean isUnacceptableValue(String input) {
        return Pattern.compile(UNACCEPTABLE_VALUE)
                      .matcher(input)
                      .find();
    }

    public static boolean isNotNull(String input) {
        return input != null;
    }

    public static boolean isNull(String input) {
        return input == null;
    }

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isNegativeInteger(String input) {
        return Pattern.compile(NEGATIVE_INTEGER)
                      .matcher(input)
                      .find();
    }

    public static boolean isPositiveInteger(String input) {
        return Pattern.compile(POSITIVE_INTEGER)
                      .matcher(input)
                      .matches();
    }

    public static boolean isCustomInputString(String input) {
        return Pattern.compile(CUSTOM_SPLIT)
                      .matcher(input)
                      .find();
    }

    public static int customSplitAndSum(String input) {
        int sum = 0;
        Matcher m = Pattern.compile(CUSTOM_SPLIT)
                           .matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] integers = m.group(2)
                                 .split(customDelimiter);
            for (String integer : integers) {
                sum += readInt(integer);
            }
        }
        return sum;
    }

    public static int normalSplitAndSum(String input) {
        String[] integers = input.split(NORMAL_SPLIT);
        int sum = 0;
        for (String integer : integers) {
            sum += readInt(integer);
        }
        return sum;
    }
}
