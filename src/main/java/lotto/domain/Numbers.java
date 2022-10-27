package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    public static final int DEFAULT_LOTTO_SIZE = 6;
    private final List<Number> numbers;

    public Numbers(List<Integer> integerNumbers) {
        validNumbers(integerNumbers);
        numbers = integerNumbers.stream()
                .map(Number::from)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    private void validNumbers(List<Integer> integerNumbers) {
        if (integerNumbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException(DEFAULT_LOTTO_SIZE + "개의 숫자를 입력하세요.");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", "));
    }
}
