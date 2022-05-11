package stringcalculator.utils;

import static stringcalculator.utils.PositiveIntegerChecker.isPositiveInteger;

import java.util.ArrayList;
import java.util.List;

public class PositiveIntegerConverter {

    public static List<Integer> convertToPositiveIntegers(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            addPositiveInteger(numbers, value);
        }
        return numbers;
    }

    private static void addPositiveInteger(List<Integer> numbers, String value) {
        if (isPositiveInteger(value)) {
            numbers.add(convertInteger(value));
        }
    }

    private static int convertInteger(String value) {
        return Integer.parseInt(value);
    }

}
