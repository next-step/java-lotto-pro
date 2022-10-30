package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumberGenerator implements LottoNumberGenerator {
    private static final int START_INDEX = 0;
    private static final int LOTTO_LOTTERY_NUMBER_SIZE = 6;

    @Override
    public Set<LottoNumber> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(START_INDEX, LOTTO_LOTTERY_NUMBER_SIZE).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
