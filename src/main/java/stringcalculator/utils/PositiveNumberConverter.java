package stringcalculator.utils;

import java.util.ArrayList;
import java.util.List;
import stringcalculator.vo.PositiveNumber;

public class PositiveNumberConverter {

    private PositiveNumberConverter() {
    }

    public static List<PositiveNumber> convertToPositiveNumbers(String[] values) {
        List<PositiveNumber> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(PositiveNumber.from(value));
        }
        return numbers;
    }

}
