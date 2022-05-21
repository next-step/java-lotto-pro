package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public final class RandomNumbersGenerator {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final List<Number> ENTIRE_LOTTO_NUMBERS = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(Number::from)
            .collect(Collectors.toList());
    private static final int MINIMUM_PICK_SIZE = 0;
    private static final int MAXIMUM_PICK_SIZE = 45;

    private RandomNumbersGenerator() {
    }

    public static List<Number> generate(int size) {
        if (size < MINIMUM_PICK_SIZE || size > MAXIMUM_PICK_SIZE) {
            throw new IllegalArgumentException("0개 이상 45개 이하만 선택할 수 있습니다");
        }
        shuffle(ENTIRE_LOTTO_NUMBERS);
        return new ArrayList<>(ENTIRE_LOTTO_NUMBERS.subList(0, size));
    }
}
