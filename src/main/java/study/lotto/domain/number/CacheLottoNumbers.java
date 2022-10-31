package study.lotto.domain.number;

import study.message.LottoExceptionCode;
import study.util.NumberUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class CacheLottoNumbers {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private static Map<Integer, LottoNumber> cacheLottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .forEach((num) -> cacheLottoNumbers.put(num, new LottoNumber(num)));
    }

    public static LottoNumber of(String number) {
        try {
            return of(NumberUtil.convertToPositiveIntNotContainsZero(number));
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static LottoNumber of(int number) {
        if(Objects.isNull(cacheLottoNumbers.get(number))) {
            throw new IllegalArgumentException(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
        }

        return cacheLottoNumbers.get(number);
    }
}
