package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int START_INDEX = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    public static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MIN, MAX).boxed()
        .collect(Collectors.toList());

    private LottoMachine() {
    }

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return Collections.unmodifiableList(LOTTO_NUMBERS.subList(START_INDEX, LOTTO_NUMBER_SIZE));
    }
}
