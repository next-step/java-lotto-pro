package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final int CHECK_START_DELIMITER_INDEX = 0;
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_INPUT_TEXT_INDEX = 2;
    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");
    private static final String ONLY_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final String COMMA_AND_COLON = ",|:";

    private StringAddCalculator() {}

    public static int splitAndSum(String inputNumberText) {
        if (isEmpty(inputNumberText)) {
            return ZERO;
        }
        return calculateNumber(inputNumberText);
    }

    private static int calculateNumber(String inputNumberText) {
        if (isCustomDelimeter(inputNumberText)) {
            return addNumberByCustomDelimiter(inputNumberText);
        }

        String[] numbers = inputNumberText.split(COMMA_AND_COLON);
        return addNumber(numbers);
    }

    private static int addNumberByCustomDelimiter(String inputNumberText) {
        Matcher m = customPattern.matcher(inputNumberText);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            String[] tokens = m.group(CUSTOM_DELIMITER_INPUT_TEXT_INDEX).split(customDelimiter);
            return addNumber(tokens);
        }
        throw new RuntimeException("잘못된 문자를 입력하였습니다.(숫자만 입력가능)");
    }

    private static boolean isCustomDelimeter(String inputNumberText) {
        return inputNumberText.charAt(CHECK_START_DELIMITER_INDEX) == '/';
    }

    private static int addNumber(String[] numbers) {
        checkWrongNumber(numbers);
        int sum = ZERO;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void checkWrongNumber(String[] numbers) {
        for (String number : numbers) {
            findWrongNumber(number);
        }
    }

    private static void findWrongNumber(String number) {
        if (!Pattern.matches(ONLY_NUMBER_REGULAR_EXPRESSION, number)) {
            throw new RuntimeException("잘못된 문자를 입력하였습니다.(숫자만 입력가능)");
        }
    }

    private static boolean isEmpty(String inputNumberText) {
        return inputNumberText == null || inputNumberText.isEmpty();
    }
}
