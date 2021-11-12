package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern PATTERN_DELIMITERS = Pattern.compile("[,:]");
    private static final Pattern PATTERN_CUSTOM = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;
    private static final String MESSAGE_NOT_POSITIVE_INT = "For input only positive integers.";

    public static int splitAndSum(String str) {
        if( str == null || str.isEmpty() ) {
            return ZERO;
        }

        if( str.length() == 1 ) {
            return checkOneNumber(str);
        }

        Matcher matcher = PATTERN_CUSTOM.matcher(str);
        if( matcher.find() ) {
            return checkCustomDelimiter(matcher);
        }

        return checkSeparatorAndDelimiter(str);
    }

    private static int checkOneNumber(String str) {
        return Integer.parseInt(str);
    }

    private static int checkSeparatorAndDelimiter(String str) {
        String[] token = PATTERN_DELIMITERS.split(str);
        return addStringArray(token);
    }

    private static int checkCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        return addStringArray(tokens);
    }

    private static int addStringArray(String[] strs) {
        int result = ZERO;
        for(String str : strs) {
            result += checkInt(Integer.parseInt(str));
        }
        return result;
    }

    private static int checkInt(int number) {
        if( number < ZERO ) {
            throw new IllegalArgumentException(MESSAGE_NOT_POSITIVE_INT);
        }
        return number;
    }

    private StringAddCalculator(){}
}