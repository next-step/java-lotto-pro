package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE;

public class LottoNumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> LOTTO_GENERATOR = IntStream
            .rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(toList());

    private final List<Integer> lotto;

    public LottoNumberGenerator() {
        this.lotto = LOTTO_GENERATOR;
    }

    public List<Integer> generate() {
        Collections.shuffle(lotto);

        return lotto.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(toList());
    }
}
