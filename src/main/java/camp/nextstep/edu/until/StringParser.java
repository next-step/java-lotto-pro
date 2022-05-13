package camp.nextstep.edu.until;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_SPLIT_SEPARATOR_REGEX = "[:,]";
    private static final String SPECIAL_SPLIT_LEFT_SEPARATOR = "//";
    private static final String SPECIAL_SPLIT_RIGHT_SEPARATOR = "\n";
    private static final Pattern SPECIAL_SPLIT_SEPARATOR_REGEX =
            Pattern.compile("[^" + SPECIAL_SPLIT_LEFT_SEPARATOR + "].*" + "(?=" + SPECIAL_SPLIT_RIGHT_SEPARATOR + ")");

    private StringParser() {}

    public static List<String> parseAndSplit(String target) {
        String splitTarget = convertIfNullToEmpty(target);
        String separator = parseSplitSeparator(splitTarget);

        if (!separator.equals(DEFAULT_SPLIT_SEPARATOR_REGEX)) {
            splitTarget = splitTarget.substring(splitTarget.indexOf(SPECIAL_SPLIT_RIGHT_SEPARATOR) + 1);
        }

        return Arrays.asList(splitTarget.split(separator));
    }

    private static String parseSplitSeparator(String target) {
        String separator = DEFAULT_SPLIT_SEPARATOR_REGEX;
        Matcher regexResult = SPECIAL_SPLIT_SEPARATOR_REGEX.matcher(target);

        if (regexResult.find()) {
            checkStartBySpecialSeparator(regexResult);
            separator = "\\" + String.join( "\\", regexResult.group().split(""));
        }

        return separator;
    }

    private static void checkStartBySpecialSeparator(Matcher matcher) {
        if (matcher.start() !=  SPECIAL_SPLIT_LEFT_SEPARATOR.length()) {
            throw new RuntimeException("구분자는 문자열 시작에 위치해야 합니다.");
        }
    }

    private static String convertIfNullToEmpty(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
