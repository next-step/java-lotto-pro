package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private static final String COMMA_OR_COLON_PATTERN = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    private static final int SEPARATOR = 1;
    private static final int OPERANDS = 2;

    public static List<String> separate(String source) {

        Matcher matcher = Pattern.compile(CUSTOM_PATTERN).matcher(source);
        if (matcher.find()) {
            return customSeparate(matcher);
        }
        return basicSeparate(source);
    }

    private static List<String> basicSeparate(String source) {
        return Arrays.stream(source.split(COMMA_OR_COLON_PATTERN))
                .collect(Collectors.toList());
    }

    private static List<String> customSeparate(Matcher matcher) {
        String customSeparator = matcher.group(SEPARATOR);
        return Arrays.stream(matcher.group(OPERANDS).split(customSeparator))
                .collect(Collectors.toList());
    }
}
