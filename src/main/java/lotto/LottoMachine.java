package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoMachine {

    private static List<Integer> numbers;
    private final static int LIMIT_NUMBER_COUNT = 6;

    static {
        numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toList());

    }

    public static Lotto issue() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.stream().limit(LIMIT_NUMBER_COUNT).collect(toList()));
    }
}
