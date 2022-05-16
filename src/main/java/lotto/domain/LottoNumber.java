package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.*;

public class LottoNumber {
    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    private final int lottoNumber;

    static {
        for (int i = Constants.MIN_LOTTO_NUMBER; i <= Constants.MAX_LOTTO_NUMBER; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public static LottoNumber from(int number) {
        LottoNumber lottoNumber = lottoNumberMap.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER);
        }
        return lottoNumber;
    }

    public static Set<Integer> allLottoNumbers() {
        return lottoNumberMap.keySet();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
