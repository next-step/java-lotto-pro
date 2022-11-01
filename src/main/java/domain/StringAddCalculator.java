package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFALUT_DELIMETER = ",|:";
    private static final String CUSTOM_DELIMETER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMETER);

    public static final int CUSTOM_PATTHERN_DELIMITER_INDEX = 1;
    public static final int CUSTOM_PATTERN_TEXT_INDEX = 2;

    public String[] split(String inputStr) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputStr);
        if (matcher.find()) {
            return matcher.group(CUSTOM_PATTERN_TEXT_INDEX).split(matcher.group(CUSTOM_PATTHERN_DELIMITER_INDEX));
        }
        return inputStr.split(DEFALUT_DELIMETER);

    }

    public int splitAndSum(String inputStr) {
        if (isNullOrEmpty(inputStr)) {
            return 0;
        }
        String[] stringNumbers = split(inputStr);

        return sum(stringNumbers);
    }

    private int sum(String[] stringNumbers) {
        int sum = 0;
        Numbers numbers = new Numbers(stringNumbers);

        for (int number : numbers.getNumbers()) {
            sum += number;
        }

        return sum;
    }

    public boolean isNullOrEmpty(String inputStr) {
        return inputStr == null || inputStr.isEmpty();
    }

}
