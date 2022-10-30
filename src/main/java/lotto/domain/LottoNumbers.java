package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int MAX_LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> GENERATE_LOTTO_NUMBERS = new ArrayList<>();
    private final List<LottoNumber> lottoNumbers;

    static {
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            GENERATE_LOTTO_NUMBERS.add(LottoNumber.of(i));
        }
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generate() {
        Collections.shuffle(GENERATE_LOTTO_NUMBERS);
        return new LottoNumbers(GENERATE_LOTTO_NUMBERS.stream().limit(MAX_LOTTO_NUMBER_COUNT).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
