package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> create() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return LOTTO_NUMBER_POOL.stream()
                .limit(Lotto.SIZE)
                .collect(Collectors.toList());
    }
}
