package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int START_LOTTO_NUMBER_RANGE = 1;
    private static final int END_LOTTO_NUMBER_RANGE = 45;

    private static final int START_LOTTO_NUMBER_INDEX = 0;
    private static final int MAX_LOTTO_NUMBER_INDEX = 6;

    private static final List<Integer> numbers;

    static {
        numbers = IntStream.range(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generate() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(START_LOTTO_NUMBER_INDEX, MAX_LOTTO_NUMBER_INDEX));
    }
}
