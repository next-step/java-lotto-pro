package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;

    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (hasCustomDelimiter(text)) {
            return sumNumbers(convertStringArrayToIntArray(splitTextWithCustomDelimiter(text)));
        }
        return sumNumbers(convertStringArrayToIntArray(splitText(text, DELIMITER)));
    }

    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean hasCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
    }

    private static String[] splitTextWithCustomDelimiter(String text) {
        Matcher matcher = makePatterFindMatcher(text);
        String customDelimiter = findCustomDelimiter(matcher);
        return splitText(findInputText(matcher), customDelimiter);
    }

    private static Matcher makePatterFindMatcher(String text){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        matcher.find();
        return matcher;
    }

    private static String findCustomDelimiter(Matcher matcher) {
        return matcher.group(DELIMITER_INDEX);
    }

    private static String findInputText(Matcher matcher) {
        return matcher.group(TEXT_INDEX);
    }

    private static int[] convertStringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    private static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
