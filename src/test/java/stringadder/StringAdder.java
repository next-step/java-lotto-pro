package stringadder;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    private static final String EXPRESSION_REGEX = "(?://(?<DELIMITER>.)\\n)?(?<TOKENS>.*)";
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final int INIT_VALUE = 0;

    public int calculate(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return INIT_VALUE;
        }

        final Matcher m = Pattern.compile(EXPRESSION_REGEX).matcher(value);

        if (!m.find()) {
            throw new IllegalArgumentException("올바른 형태가 아닙니다. value=[" + value + "]");
        }

        final String tokenString = m.group("TOKENS");

        final String customDelimiter = m.group("DELIMITER");

        String delimiters = DEFAULT_DELIMITERS;
        if (customDelimiter != null) {
            delimiters += customDelimiter;
        }
        final String delimiterRegex = "[" + delimiters + "]";

        final String[] tokens = tokenString.split(delimiterRegex);

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .reduce(INIT_VALUE, Integer::sum);
    }
}
