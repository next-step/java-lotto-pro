package calculator;

import calculator.constants.ErrorMessage;
import calculator.utils.StringSplitter;
import calculator.utils.StringToIntegerParser;
import calculator.utils.StringUtils;
import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    private static final Integer DEFAULT_RESULT = 0;
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";

    public static Integer splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return DEFAULT_RESULT;
        }
        String[] splitText = StringSplitter.split(text);
        validateConsistOfPositiveNumbers(splitText);

        List<Integer> numbers = StringToIntegerParser.parseNumbers(splitText);
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static void validateConsistOfPositiveNumbers(String[] texts) {
        boolean isAllPositiveNumbers = Arrays.stream(texts).allMatch(text -> text.matches(POSITIVE_NUMBER_REGEX));
        if (!isAllPositiveNumbers) {
            throw new RuntimeException(String.format(ErrorMessage.INVALID_INPUT_VALUE, Arrays.toString(texts)));
        }
    }
}
