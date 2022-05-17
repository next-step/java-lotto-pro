package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> numbers = new ArrayList<>();

    public Lotto(NumberGenerator numberGenerator) {
        createNumbers(numberGenerator);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers + "";
    }

    private void createNumbers(NumberGenerator numberGenerator) {
        numbers = numberGenerator.pickNumbers();
    }
}
