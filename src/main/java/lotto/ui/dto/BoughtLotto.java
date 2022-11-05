package lotto.ui.dto;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class BoughtLotto {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private final List<Integer> numbers;

    BoughtLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(joining(DELIMITER, PREFIX, SUFFIX));
    }
}
