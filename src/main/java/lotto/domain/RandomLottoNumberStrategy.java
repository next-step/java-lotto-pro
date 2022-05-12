package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<LottoNumber> create() {
        List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberPool);

        return lottoNumberPool.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
    }
}
