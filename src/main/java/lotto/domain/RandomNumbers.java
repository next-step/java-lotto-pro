package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers implements Numbers{

    private static final int MAX_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> numbers;

    static {
        numbers = IntStream.range(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> random() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }
}
