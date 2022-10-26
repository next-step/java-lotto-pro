package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");
    private static final int MATCHER_DELIMITER_POINTER = 1;
    private static final int MATCHER_INPUT_STRING_POINTER = 2;

    public static String[] split(String input){
        String delimiter = DEFAULT_DELIMITER;
        Matcher m = customPattern.matcher(input);
        if (m.find()) {
            delimiter = m.group(MATCHER_DELIMITER_POINTER);
            input = m.group(MATCHER_INPUT_STRING_POINTER);
        }
        return input.split(delimiter);
    }

}
