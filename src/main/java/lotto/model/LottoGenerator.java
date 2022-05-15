package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final String DELIMITER = ",";
    private static final int NUMBER_CRITERIA = 6;
    private static final String INVALID_SIZE = "6개의 숫자를 입력해야 합니다";
    private static final String INVALID_NUMBER = "숫자만 입력해주세요.";

    public static List<Integer> generateNumbers(String source) {
        String[] numbers = source.split(DELIMITER);
        validateSize(numbers);
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    public static int generateNumber(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private static void validateSize(String[] numbers) {
        if (numbers.length != NUMBER_CRITERIA) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }
}
