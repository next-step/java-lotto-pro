package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ManualNumberSupplier implements NumberSupplier {
    static final String EMPTY_NUMBERS_ERR_MSG = "1개 이상의 수를 제공해야합니다.";
    private final Set<Number> numbers = new HashSet<>();

    public ManualNumberSupplier(int... numbers) {
        for (int number : numbers) {
            this.numbers.add(new Number(number));
        }
        validate();
    }

    private void validate() {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NUMBERS_ERR_MSG);
        }
    }

    @Override
    public Set<Number> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
