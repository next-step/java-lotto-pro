package calculator.domain;

import calculator.exception.ExceptionType;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterPlusStrategy implements PlusStrategy {
    @Override
    public int result(String expressionStr) {
        Matcher matcher = Pattern.compile(ExpressionUtils.CUSTOM_REGEX).matcher(expressionStr);
        if (matcher.find()) {
            List<Integer> numbers = this.getSplitNumbers(matcher);
            return numbers.stream().mapToInt(x -> x).sum();
        }

        throw new IllegalStateException(ExceptionType.INVALID_EXPRESSION.getMessage());
    }

    private List<Integer> getSplitNumbers(Matcher matcher) {
        String customDelimiter = matcher.group(1);

        return Arrays.stream(matcher.group(2).split(customDelimiter)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
