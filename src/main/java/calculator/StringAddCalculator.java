package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELIMITER = "[,:]";

    public static int splitAndSum(String input) {
        return sum(changeNumbers(splitString(input)));
    }

    private static String[] splitString(String input) {
        return input.split(DELIMITER);
    }

    private static int sum(int[] inputs) {
        return Arrays.stream(inputs).sum();
    }

    private static int[] changeNumbers(String[] inputs) {
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
    }

}