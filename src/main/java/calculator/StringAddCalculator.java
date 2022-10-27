package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public static int splitAndSum(String input) {
        List<String> splitStrings = StringSplitter.split(input);
        validate(splitStrings);
        return splitStrings.stream().mapToInt(Integer::parseInt).sum();
    }

    private static void validate(List<String> splitStrings) {
        if (!checkIsNumber(splitStrings)) {
            throw new RuntimeException(CalculatorStatus.INVALID_VALUE.getMessage());
        }
        if (!checkIsPositive(splitStrings)) {
            throw new RuntimeException(CalculatorStatus.NEGATIVE_NUMBER.getMessage());
        }
    }

    private static boolean checkIsNumber(List<String> splitStrings) {
        for (String value : splitStrings) {
            Matcher matcher = NUMBER_PATTERN.matcher(value);
            if (!matcher.find()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsPositive(List<String> splitStrings) {
        for (String value : splitStrings) {
            if (Integer.parseInt(value) < 0) {
                return false;
            }
        }
        return true;
    }


}
