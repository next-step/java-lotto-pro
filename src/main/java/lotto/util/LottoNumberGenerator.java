package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;

    private static final int LOTTO_MAX_NUMBER = 45;

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> fullLottoNumbers;

    public LottoNumberGenerator() {
        this.fullLottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public List<Integer> generate() {
        Collections.shuffle(fullLottoNumbers);
        List<Integer> lottoNumbers = fullLottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
