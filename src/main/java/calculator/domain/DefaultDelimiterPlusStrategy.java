package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class DefaultDelimiterPlusStrategy implements PlusStrategy {
    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public int result(String expressionStr) {
        List<String> stringList = Arrays.asList(expressionStr.split(DEFAULT_DELIMITER));
        return stringList.stream().mapToInt(Integer::parseInt).sum();
    }
}
