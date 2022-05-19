package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

public class LottoNumbers {
    public static final List<LottoNumber> LOTTO_NUMBERS = Collections.unmodifiableList(initializeNumbers());

    private LottoNumbers() {
    }

    private static List<LottoNumber> initializeNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return LOTTO_NUMBERS.toString();
    }
}
