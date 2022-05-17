package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class RandomNumbersGenerator {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_PICK_SIZE = 0;
    private static final int MAXIMUM_PICK_SIZE = 45;
    private final List<Number> numbers;

    public RandomNumbersGenerator() {
        numbers = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .mapToObj(Number::from)
                .collect(Collectors.toList());
    }

    public List<Number> generate(int size) {
        if (size < MINIMUM_PICK_SIZE || size > MAXIMUM_PICK_SIZE) {
            throw new IllegalArgumentException("0개 이상 45개 이하만 선택할 수 있습니다");
        }
        shuffle(numbers);
        return numbers.subList(0, size);
    }
}
