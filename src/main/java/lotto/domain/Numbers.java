package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private static final int DEFAULT_LOTTO_SIZE = 6;
    private final Set<Number> numbers;

    public Numbers(List<Integer> integerNumbers) {
        numbers = integerNumbers.stream()
                .map(Number::from)
                .collect(Collectors.toSet());
        validNumbers();
    }

    private boolean contains(Number number) {
        return numbers.contains(number);
    }

    private void validNumbers() {
        if (numbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException("서로 다른" + DEFAULT_LOTTO_SIZE + "개의 숫자를 입력하세요.");
        }
    }

    public int getMatchCount(Numbers numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(Number::toString)
                .collect(Collectors.joining(", "));
    }
}
