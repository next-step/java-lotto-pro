package calculator.add.string.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers).map(Number::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public int sumTotal() {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }

}
