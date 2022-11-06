package lotto.domain;

import lotto.util.InputValidator;

import java.util.HashMap;

import static lotto.util.LottoNumberGenerator.MAX_LOTTO_NUMBER;
import static lotto.util.LottoNumberGenerator.MIN_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final HashMap<Integer, LottoNumber> lottoRange;
    private final int lottoNumber;

    static {
        lottoRange = new HashMap<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoRange.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        InputValidator.validateLottoNumberRange(lottoNumber);
        return lottoRange.get(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }
}
