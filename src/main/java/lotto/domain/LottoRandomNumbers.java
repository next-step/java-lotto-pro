package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumbers {
    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS = IntStream
            .rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public LottoRandomNumbers() {
        this(DEFAULT_LOTTO_NUMBERS);
    }

    public LottoRandomNumbers(List<LottoNumber> numList) {
        this.lottoNumbers = numList;
    }

    public void LottoNumberShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> generate() {
        LottoNumberShuffle();

        return lottoNumbers.stream()
                .limit(SIZE)
                .collect(Collectors.toList());
    }
}
