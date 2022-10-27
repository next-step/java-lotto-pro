package step2;

import java.util.Arrays;

public class NumberValidator {
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";
    private static final String NOT_POSITIVE_NUMBER = "0~9 사이의 숫자가 아닙니다.";

    public static void validateNumbersPositive(String[] splitNumbers) {
        boolean isValidate = Arrays.stream(splitNumbers).allMatch(number->number.matches(POSITIVE_NUMBER_REGEX));
        if (!isValidate){
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER);
        }
    }
}
