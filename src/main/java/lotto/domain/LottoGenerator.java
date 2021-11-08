package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final List<Integer> LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumbers.MIN_LOTTO_NUMBER, LottoNumbers.MAX_LOTTO_NUMBER)
                    .boxed()
                    .collect(toList());

    private LottoGenerator() {
    }

    public static LottoNumbers generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> lottoNumbers = LOTTO_NUMBERS.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(toList());
        return new LottoNumbers(lottoNumbers);
    }

}
