package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<Integer> fullLottoNumbers;

    static {
        fullLottoNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> generate() {
        Collections.shuffle(fullLottoNumbers);
        List<Integer> lottoNumbers = fullLottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
