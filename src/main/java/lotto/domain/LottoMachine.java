package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private final static List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());

    private static void shuffleNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
    }

    private static List<Integer> divideNumberList() {
        return LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    public Set<Integer> issueLottoNumber() {
        shuffleNumbers();
        return new HashSet<>(divideNumberList());
    }
}
