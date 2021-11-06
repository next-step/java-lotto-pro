package study.lotto.model;

import study.lotto.model.exception.MalFormedLottoNumberException;

import java.util.HashMap;

public class LottoNumber {

    private static final String MAL_FORMED_LOTTO_NUMBER_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(final int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(final int lottoNumber) {

        if (LottoNumberCache.low <= lottoNumber && lottoNumber <= LottoNumberCache.high) {
            LottoNumberCache.cache.get(lottoNumber);
        }

        return new LottoNumber(lottoNumber);
    }

    public int getValue() {
        return this.lottoNumber;
    }

    private void validate(final int lottoNumber) {
        if (MIN_NUMBER > lottoNumber || lottoNumber > MAX_NUMBER) {
            throw new MalFormedLottoNumberException(MAL_FORMED_LOTTO_NUMBER_MESSAGE);
        }
    }

    private static class LottoNumberCache {
        static final HashMap<Integer, LottoNumber> cache;
        static int low = MIN_NUMBER;
        static int high = MAX_NUMBER;

        static {
            final HashMap<Integer, LottoNumber> _cache = new HashMap<>();
            for (int i = low; i <= high; i++) {
                _cache.put(i, new LottoNumber(i));
            }
            cache = _cache;
        }
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
        return lottoNumber;
    }
}
