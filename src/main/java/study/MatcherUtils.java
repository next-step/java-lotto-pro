package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MatcherUtils {
    private static final String DELIMITER = ",|:";
    private static final String REGEX = "//(.)\n(.*)";

    public static List<Integer> extractNumber(String str) {
        Matcher m = Pattern.compile(REGEX).matcher(str);

        if (isMatched(m)) {
            String customDelimiter = m.group(1);
            return toList(m.group(2), customDelimiter);
        }

        return toList(str, DELIMITER);
    }

    private static boolean isMatched(Matcher m) {
        return m.find();
    }

    private static List<Integer> toList(String str, String delimiter) {
        return Arrays.stream(str.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
