package calculator.domain;

import java.util.Arrays;

public class ArrayCalculator {
    private ArrayCalculator() {
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
