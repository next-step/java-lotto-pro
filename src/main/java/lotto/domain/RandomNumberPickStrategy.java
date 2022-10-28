package lotto.domain;

import static lotto.domain.Number.MAX_LOTTO_NUMBER;
import static lotto.domain.Number.MIN_LOTTO_NUMBER;
import static lotto.domain.Numbers.DEFAULT_LOTTO_SIZE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberPickStrategy implements NumberPickStrategy {

    public static final int FROM_INDEX = 0;
    private static final List<Integer> numberMap = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());


    @Override
    public List<Integer> pick() {
        Collections.shuffle(numberMap);
        return numberMap.subList(FROM_INDEX, DEFAULT_LOTTO_SIZE);
    }
}
