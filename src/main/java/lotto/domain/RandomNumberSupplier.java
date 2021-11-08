package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomNumberSupplier implements NumberSupplier {

    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final List<Integer> numbers;

    static  {
        numbers = IntStream.rangeClosed(START_NUMBER, LAST_NUMBER)
                .boxed()
                .collect(toList());
    }

    @Override
    public List<Integer> getAsInts(int digit) {
        Collections.shuffle(numbers);
        return this.numbers.stream().limit(digit).collect(toList());
    }
}
