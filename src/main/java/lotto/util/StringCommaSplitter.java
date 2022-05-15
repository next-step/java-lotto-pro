package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCommaSplitter {
    private static final String COMMA_DELIMITER_REGEX = "\\s*,\\s*";

    public static List<Integer> splitNumbers(String inputNumber) {
        String[] splitNumbers = inputNumber.trim().split(COMMA_DELIMITER_REGEX);
        return Arrays.stream(splitNumbers)
                .mapToInt(StringToIntegerParser::parseInt)
                .boxed().collect(Collectors.toList());
    }
}
