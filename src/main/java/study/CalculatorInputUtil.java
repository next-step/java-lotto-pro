package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorInputUtil {

    public static final int DELIMITER_INDEX = 1;
    public static final int TEXT_INDEX = 2;

    public static final String DELIMITER = ",|:";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static boolean hasCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
    }

    public static String[] splitTextWithCustomDelimiter(String text) {
        Matcher matcher = makePatterFindMatcher(text);
        String customDelimiter = findCustomDelimiter(matcher);
        return StringUtil.splitText(findInputText(matcher), customDelimiter);
    }

    private static String findInputText(Matcher matcher) {
        return matcher.group(TEXT_INDEX);
    }

    private static Matcher makePatterFindMatcher(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        matcher.find();
        return matcher;
    }

    private static String findCustomDelimiter(Matcher matcher) {
        return matcher.group(DELIMITER_INDEX);
    }

}
