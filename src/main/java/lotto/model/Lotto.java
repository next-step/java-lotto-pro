package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        createNumbers(numberGenerator);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers + "";
    }

    private void createNumbers(NumberGenerator numberGenerator) {
        numbers = numberGenerator.pickNumbers();
    }
}
