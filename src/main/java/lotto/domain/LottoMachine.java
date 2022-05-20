package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.constants.ExceptionConstants.*;

public class LottoMachine {
    public static final LottoMachine INSTANCE = new LottoMachine();
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 46;
    private static final List<Integer> NUMBERS = IntStream.range(NUMBER_START, NUMBER_END).boxed().collect(Collectors.toList());
    private static final int LOTTO_SIZE_LIMIT = 6;
    private static final int PRICE = 1_000;
    private static final int ZERO = 0;




    private LottoMachine() {}

    public static LottoMachine getInstance() {
        return INSTANCE;
    }

    public int purchase(final long money) {
        return calculate(new Money(money));
    }

    private int calculate(final Money money) {
        validate(money.getValue());
        return (int) (money.getValue() / PRICE);
    }

    private void validate(final long money) {
        if (money < PRICE) {
            throw new IllegalArgumentException(LOTTO_MONEY_LEAK_EXCEPTION);
        }
    }

    private Lotto generateAuto() {
        shuffle();
        ArrayList<LottoNumber> collect = NUMBERS.stream()
                .limit(LOTTO_SIZE_LIMIT)
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(ArrayList::new));

        new Lotto(collect);

    }

    private void shuffle() {
        Collections.shuffle(NUMBERS);
    }

    public List<Lotto> generateAuto(final int count) {
        return null;
    }
}
