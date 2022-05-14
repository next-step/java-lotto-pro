package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(String[] values) {
        List<Number> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(new Number(value));
        }
        return new Numbers(numbers);
    }

    public int getTotalSum() {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }
}
