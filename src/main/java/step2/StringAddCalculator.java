package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASE_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (text == null) return 0;
        if (text.isEmpty()) return 0;
        String[] numbers = parseText(text);

        return sumCalculate(numbers);
    }

    static int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        if (result < 0) throw new RuntimeException();
        return result;
    }

    static String[] parseText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASE_DELIMITER);
    }

    private static int sumCalculate(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringAddCalculator::convertNumber)
                .sum();
    }
}
