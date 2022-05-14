package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorInputUtil {

    public static final int DELIMITER_INDEX = 1;
    public static final int TEXT_INDEX = 2;

    public static final String DELIMITER = ",|:";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] splitTextWithDelimiter(String text) {
        Matcher matcher = makePatterFindMatcher(text);
        if (matcher.find()) {
            return StringUtil.splitText(findInputText(matcher), findCustomDelimiter(matcher));
        }
        return StringUtil.splitText(text, CalculatorInputUtil.DELIMITER);
    }

    private static String findInputText(Matcher matcher) {
        return matcher.group(TEXT_INDEX);
    }

    private static Matcher makePatterFindMatcher(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }

    private static String findCustomDelimiter(Matcher matcher) {
        return matcher.group(DELIMITER_INDEX);
    }

}