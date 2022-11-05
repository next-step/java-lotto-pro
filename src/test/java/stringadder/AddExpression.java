package stringadder;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddExpression {
    private static final String EXPRESSION_REGEX = "(?://(?<DELIMITER>.)\\n)?(?<TOKENS>.*)";
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(EXPRESSION_REGEX);
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final Pattern DEFAULT_SPLITTER = Pattern.compile("[" + DEFAULT_DELIMITERS + "]");


    private final String customDelimiter;

    private final String tokenString;

    public AddExpression(final String customDelimiter, final String tokenString) {
        this.customDelimiter = customDelimiter;
        this.tokenString = tokenString;
    }

    public AddExpression(final String expression) {
        final Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        if (!matcher.find()) {
            throw new IllegalArgumentException("올바른 형태가 아닙니다. value=[" + expression + "]");
        }

        this.tokenString = matcher.group("TOKENS");
        this.customDelimiter = matcher.group("DELIMITER");
    }

    public String[] parseTokens() {
        return getTokenSplitter().split(tokenString);
    }

    private Pattern getTokenSplitter() {
        if (Objects.isNull(this.customDelimiter)) {
            return DEFAULT_SPLITTER;
        }
        return Pattern.compile("[" + DEFAULT_DELIMITERS + this.customDelimiter + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddExpression that = (AddExpression) o;
        return Objects.equals(customDelimiter, that.customDelimiter) && Objects.equals(tokenString,
                that.tokenString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customDelimiter, tokenString);
    }
}
