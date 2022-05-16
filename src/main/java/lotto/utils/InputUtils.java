package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    private static final String NUMBERS_DELIMITER = ",";

    public static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다!");
        }
    }

    public static List<Integer> convertToIntegerList(List<String> input) {
        return input.stream()
                .map(InputUtils::convertToInteger)
                .collect(Collectors.toList());
    }

    public static List<String> splitWithDelimiter(String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
