package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculateParser {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int CUSTOM_CALCULATE_INDEX = 2;
    public static final String CUSTOM_CALCULATOR_REGEX = "//(.)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_STRING_COMPILE_PATTERN = Pattern.compile(CUSTOM_CALCULATOR_REGEX);

    public static String[] parseStringToArray(String input) {
        Matcher matcher = CUSTOM_DELIMITER_STRING_COMPILE_PATTERN.matcher(input);
        if(matcher.find()){
            return matcher.group(CUSTOM_CALCULATE_INDEX).split(matcher.group(CUSTOM_DELIMITER_INDEX));
        }

        return input.split(DEFAULT_DELIMITER);
    }

}
