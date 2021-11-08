package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final int MATCH_GROUP_DELIMITER = 1;
    private static final int MATCH_GROUP_NUMBER = 2;
    private static final String REGEX_FIND_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(REGEX_FIND_DELIMITER);
    private static final int EMPTY_TEXT_RESULT = 0;

    private static Delimiters delimiters;
    private static NumbersText numbersText;

    public static int splitAndSum(String text) {
        if (isNullOrEmptyString(text)) {
            return EMPTY_TEXT_RESULT;
        }

        parseString(text);
        Numbers numbers = new Numbers(getSplitNumbersText());
        return numbers.getSum();
    }

    public static boolean isNullOrEmptyString(String text) {
        return text == null || text.isEmpty();
    }

    private static void parseString(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            delimiters = new Delimiters(DEFAULT_DELIMITERS + matcher.group(MATCH_GROUP_DELIMITER));
            numbersText = new NumbersText(matcher.group(MATCH_GROUP_NUMBER));
            return;
        }

        delimiters = new Delimiters(DEFAULT_DELIMITERS);
        numbersText = new NumbersText(text);
    }

    public static String[] getSplitNumbersText() {
        return numbersText.splitNumbersText(delimiters);
    }
}
