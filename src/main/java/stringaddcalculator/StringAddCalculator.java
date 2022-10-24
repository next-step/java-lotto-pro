package stringaddcalculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] strings = input.split("[,:]");
        if (strings.length == 1) {
            return Integer.parseInt(input);
        }

        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
