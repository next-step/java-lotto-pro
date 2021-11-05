package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class LottoMachine {

    private static List<Integer> numbers;
    private final static int LIMIT_NUMBER_COUNT = 6;
    private final static int UNIT = 1000;
    private final static String ILLEGAL_AMOUNT_ERROR_MESSAGE = "적절하지 않은 금액입니다.";

    static {
        numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toList());

    }

    private static void validate(long amount) {
        if(amount % UNIT > 0) {
            throw new IllegalArgumentException(ILLEGAL_AMOUNT_ERROR_MESSAGE);
        }
    }

    public static Lottos issue(long amount) {
        validate(amount);
        long count = amount / UNIT;
        List<Lotto> lottos = LongStream.rangeClosed(1, count)
                .mapToObj(l -> issue())
                .collect(toList());

        return new Lottos(lottos);
    }

    private static Lotto issue() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.stream().limit(LIMIT_NUMBER_COUNT).collect(toList()));
    }
}
