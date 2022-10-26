package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if(isEmptyOrNull(text))return DEFAULT_VALUE;
        String[] tokens = text.split(DEFAULT_DELIMITER);
        return sumNumbers(tokens);
    }

    private static boolean isEmptyOrNull(String text){
        return text == null || text.isEmpty();
    }

    private static int sumNumbers(String[] numbers){
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }



}
