package stringaddcalculator;

import java.util.List;

public class ValidateStringUtils {

    private ValidateStringUtils() {
        throw new UnsupportedOperationException();
    }

    public static void validatePositiveNumber(List<Integer> values) {
        for (Integer value : values) {
            if (value < 0) {
                throw new RuntimeException("음수가 될 수 없습니다.");
            }
        }

    }
}
