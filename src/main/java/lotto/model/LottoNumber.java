package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = initLottoNumberCache();

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        if (LOTTO_NUMBER_CACHE.containsKey(lottoNumber)) {
            return LOTTO_NUMBER_CACHE.get(lottoNumber);
        }
        return new LottoNumber(lottoNumber);
    }

    private static Map<Integer, LottoNumber> initLottoNumberCache() {
        Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumberCache.put(i, new LottoNumber(i));
        }
        return lottoNumberCache;
    }

    private void validateLottoRange(int lottoNumber) {
        if (isNotLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자 범위가 아닙니다.");
        }
    }

    private boolean isNotLottoNumberRange(int lottoNumber) {
        return lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }
}
