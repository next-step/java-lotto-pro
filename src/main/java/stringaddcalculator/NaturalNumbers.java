package stringaddcalculator;

import java.util.Collections;
import java.util.List;

public class NaturalNumbers {

    private final List<NaturalNumber> numbers;

    public NaturalNumbers(List<NaturalNumber> numbers) {
        this.numbers = numbers;
    }

    public NaturalNumbers() {
        this.numbers = Collections.emptyList();
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(NaturalNumber::getValue)
            .sum();
    }
}
