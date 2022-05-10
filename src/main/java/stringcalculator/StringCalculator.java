package stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String input) {
        String[] split = input.split(",|:");
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }

}
