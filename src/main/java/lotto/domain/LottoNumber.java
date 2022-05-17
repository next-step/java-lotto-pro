package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final Map<Integer, LottoNumber> lottoNumbersCache = new HashMap();
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final String WRONG_LOTTO_NUMBER_ERROR_MESSAGE = "잘못된 로또 번호입니다";

    private final int lottoNumber;

    static {
        IntStream.rangeClosed(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER)
                .forEach(lottoNumber -> lottoNumbersCache.put(lottoNumber, new LottoNumber(lottoNumber)));
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String lottoNumber) {
        return of(Integer.parseInt(lottoNumber));
    }

    public static LottoNumber of(int lottoNumber) {
        LottoNumber cachedLottoNumber = lottoNumbersCache.get(lottoNumber);
        validateLottoNumber(cachedLottoNumber);
        return cachedLottoNumber;
    }

    private static void validateLottoNumber(LottoNumber cachedLottoNumber) {
        if (cachedLottoNumber == null) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
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

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
