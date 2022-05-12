package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers = new ArrayList<>();

    public Numbers(String[] tokens) {
        for (String token : tokens) {
            numbers.add(new Number(token));
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::value)
                .sum();
    }
}
