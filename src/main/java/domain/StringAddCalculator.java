package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.internal.joptsimple.internal.Strings.isNullOrEmpty;

public class StringAddCalculator {
    private static final String DEFALUT_DELIMETER = ",|:";
    private static final String CUSTOM_DELIMETER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMETER);

    public static final int CUSTOM_PATTHERN_DELIMITER_INDEX = 1;
    public static final int CUSTOM_PATTERN_TEXT_INDEX = 2;

    public static String[] split(String inputStr) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputStr);
        if(matcher.find()){
            return matcher.group(CUSTOM_PATTERN_TEXT_INDEX).split(matcher.group(CUSTOM_PATTHERN_DELIMITER_INDEX));
        }
        return inputStr.split(DEFALUT_DELIMETER);

    }



}
