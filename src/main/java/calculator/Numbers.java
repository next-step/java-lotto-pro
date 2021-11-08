package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] numbersText) {
        this.numbers = generateNumbers(numbersText);
    }

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    private List<Number> generateNumbers(String[] numbersText) {
        List<Number> resultNumbers = new ArrayList<>();
        for (String numberText : numbersText) {
            resultNumbers.add(new Number(numberText));
        }
        return resultNumbers;
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
