package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numberList = new ArrayList<>();

    public Numbers(String[] numberStringArray) {
        for (String numberString : numberStringArray) {
            numberList.add(new Number(numberString));
        }
    }

    public int sum() {
        return numberList.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}
