package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private static final String COMMA_OR_COLON_PATTERN = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    public List<String> separate(String source) {

        Matcher matcher = Pattern.compile(CUSTOM_PATTERN).matcher(source);
        if (matcher.find()) {
            return customSeparate(matcher);
        }
        return basicSeparate(source);
    }

    private List<String> basicSeparate(String source) {
        return Arrays.stream(source.split(COMMA_OR_COLON_PATTERN))
                .collect(Collectors.toList());
    }

    private List<String> customSeparate(Matcher matcher) {
        final int separator = 1;
        final int operands = 2;
        String customSeparator = matcher.group(separator);
        return Arrays.stream(matcher.group(operands).split(customSeparator))
                .collect(Collectors.toList());
    }
}
