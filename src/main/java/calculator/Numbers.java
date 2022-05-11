package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] values) {
        List<Number> numbers = new ArrayList<>();
        for (String value : values) {
            Number number = new Number(value);
            numbers.add(number);
        }
        this.numbers = numbers;
    }

    public int getTotalSum() {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }
}
