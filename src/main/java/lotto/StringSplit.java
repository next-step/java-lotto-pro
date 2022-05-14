package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {
    private static final String PIPE_VALUE = "|";
    private static final String[] SPLIT_DELIMITER_LIST_VALUE = {",", ":"};
    private static final String CUSTOM_SPLIT_DELIMITER_REGEX_VALUE = "//(.)\n(.*)";

    public static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_SPLIT_DELIMITER_REGEX_VALUE).matcher(text);

        if (!m.find())
            return text.split(stringListToString(PIPE_VALUE, Arrays.asList(SPLIT_DELIMITER_LIST_VALUE)));

        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    private static String stringListToString(String division, List<String> stringList) {
        return String.join(division, stringList);
    }
}
