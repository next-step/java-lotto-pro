package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final String DELIMITER = ",";
    private static final int NUMBER_CRITERIA = 6;
    private static final String INVALID_SIZE = "6개의 숫자를 입력해야 합니다";

    public static List<Integer> generate(String source) {
        String[] numbers = source.split(DELIMITER);
        validateSize(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateSize(String[] numbers) {
        if (numbers.length != NUMBER_CRITERIA) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }
}
