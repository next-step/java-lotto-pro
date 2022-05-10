package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return calculateSum(parseToInts(splitWithDelimiter(text)));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitWithDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] parseToInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int index = 0; index < values.length; index++) {
            int number = Integer.parseInt(values[index]);
            if (number < 0) {
                throw new RuntimeException("[ERROR] 숫자는 0보다 커야 합니다.");
            }
            numbers[index] = number;
        }
        return numbers;
    }
}
