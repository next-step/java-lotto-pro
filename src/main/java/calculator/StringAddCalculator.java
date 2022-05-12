package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String MSG_NOT_NUMBER = "숫자 이외의 값을 입력으로 받을 수 없습니다.";
    private static final String MSG_NEGATIVE = "음수를 입력으로 받을 수 없습니다";

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return 0;
        }
        return sumNumbers(splitToNumberArray(input));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private static List<Integer> splitToNumberArray(String input) {

        List<Integer> numbers = new ArrayList<>();
        for (String splitInput : split(input)) {
            validateSplitInput(splitInput);
            numbers.add(Integer.parseInt(splitInput));
        }
        return numbers;
    }

    private static String[] split(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DELIMITER);
    }

    private static int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }


    private static void validateSplitInput(String splitInput) {
        if (!splitInput.matches("\\p{Digit}")) {
            throw new RuntimeException(MSG_NOT_NUMBER);
        }
        if (Integer.parseInt(splitInput) < 0) {
            throw new RuntimeException(MSG_NEGATIVE);
        }
    }

}
