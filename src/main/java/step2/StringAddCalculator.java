package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public int sum(String inputText) {
        if (validateInputText(inputText)) {
            return 0;
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
            result += Integer.parseInt(stringNumber);
        }
        return result;
    }

    private String[] splitText(String inputText) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return inputText.split(DEFAULT_DELIMITER);
    }
}
