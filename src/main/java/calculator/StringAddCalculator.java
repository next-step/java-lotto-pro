package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DELIMITER = "[,:]";
    private static final String DELIMITER_REGX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        return sum(changeNumbers(split(input)));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(DELIMITER_REGX).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DELIMITER);
    }

    private static int sum(int[] inputs) {
        return Arrays.stream(inputs).sum();
    }

    private static int[] changeNumbers(String[] inputs) {
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
    }

}