package study.step3.domain.lottonumber;

import study.step3.message.LottoMessage;
import study.step3.util.Patterns;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LottoNumber {

    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final ConcurrentMap<Integer, LottoNumber> LOTTO_NUMBER_CACHE;
    private final int lottoNumber;

    static {
        LOTTO_NUMBER_CACHE = createLottoNumberCache();
    }

    private static ConcurrentMap<Integer, LottoNumber> createLottoNumberCache() {
        ConcurrentMap<Integer, LottoNumber> lottoNumberCache = new ConcurrentHashMap<>();
        for(int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; i++) {
            lottoNumberCache.put(i, new LottoNumber(i));
        }
        return lottoNumberCache;
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String lottoNumber) {
        validateNumber(lottoNumber);
        return of(Integer.parseInt(lottoNumber));
    }

    private static void validateNumber(String number) {
        validateIsNotEmpty(number);
        validateIsNumber(number);
    }

    private static void validateIsNotEmpty(String number) {
        if(number == null || number.isEmpty()) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_SHOULD_BE_NOT_EMPTY.message());
        }
    }

    private static void validateIsNumber(String number) {
        if(!Patterns.ONLY_NUMBERS.match(number)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_SHOULD_BE_NUMBER.message());
        }
    }

    public static LottoNumber of(int lottoNumber) {
        validateNumberIsGreaterThanMinimum(lottoNumber);
        validateNumberIsLessThanMaximum(lottoNumber);
        return LOTTO_NUMBER_CACHE.get(lottoNumber);
    }

    private static void validateNumberIsGreaterThanMinimum(int lottoNumber) {
        if(lottoNumber < LOTTO_MINIMUM_NUMBER) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_IS_GREATER_THAN_MINIMUM.message());
        }
    }

    private static void validateNumberIsLessThanMaximum(int lottoNumber) {
        if(lottoNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_IS_LESS_THAN_MAXIMUM.message());
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

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
