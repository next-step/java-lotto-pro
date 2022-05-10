package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (isValidationCheckNullOrEmpty(text)) {
            return 0;
        }

        if (isNegativeNumbers(text)) {
            throw new RuntimeException("음수 값은 입력할 수 없습니다.");
        }

        Integer result = customDelimiterAddCalculator(text);
        if (result != null) {
            return result;
        }

        return standardStringAddCalculator(text);
    }

    private static boolean isValidationCheckNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int standardStringAddCalculator(String text) {
        String[] tokens = text.split(",|:");

        return getSum(tokens);
    }

    private static boolean isNegativeNumbers(String text) {
        return text.contains("-");
    }

    private static Integer customDelimiterAddCalculator(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return getSum(tokens);
        }

        return null;
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
