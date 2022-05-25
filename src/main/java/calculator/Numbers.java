package calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers).map(Number::new).collect(toList());
    }

    public int sum() {
        return numbers.stream().mapToInt(Number::getValue).sum();
    }

}
