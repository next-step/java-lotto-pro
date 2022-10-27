package step2;


import java.util.Arrays;

public class StringAddCalculator {

    private static final int DEFAULT_EMPTY_RETURN = 0;

    public static int splitAndSum(String text) {
        if (isStringNullOrEmpty(text)) {
            return DEFAULT_EMPTY_RETURN;
        }
        String[] splitNumbers = SplitFactory.splitNumber(text);
        NumberValidator.validateNumbersPositive(splitNumbers);
        return addAllNumbers(splitNumbers);
    }

    private static int addAllNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt).sum();
    }

    private static boolean isStringNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }




}
