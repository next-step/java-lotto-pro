package calculator.utils;

import java.util.Arrays;

public class CalculatorValidator {

    public static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    public static void validatePositiveNumber(String[] strings) {
        Arrays.stream(strings).forEach(s -> positiveNumber(Integer.parseInt(s)));
    }

    private static void positiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("양수를 입력해주시기 바랍니다.");
        }
    }
}
