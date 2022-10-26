package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final String MINUS_NUMBER_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다.";
    private static final int NUMBER_RETURNED_WHEN_EMPTY_OR_NULL = 0;

    public int sum(String inputText) {
        if (validateInputText(inputText)) {
            return NUMBER_RETURNED_WHEN_EMPTY_OR_NULL;
        }
        return splitAndSum(inputText);
    }

    private boolean validateInputText(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }

    private int splitAndSum(String inputText) {
        String[] stringNumbers = splitText(inputText);
        int result = 0;
        for (String stringNumber : stringNumbers) {
            result += parseInt(stringNumber);
        }
        return result;
    }

    private int parseInt(String stringNumber) {
        int inputNumber = Integer.parseInt(stringNumber);
        validationMinusNumber(inputNumber);
        return inputNumber;
    }

    private String[] splitText(String inputText) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return inputText.split(DEFAULT_DELIMITER);
    }

    private void validationMinusNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(MINUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
