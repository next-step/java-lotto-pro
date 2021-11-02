package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split("[,:]");
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
