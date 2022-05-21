package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final Map<Integer, LottoNumber> cachedLottoNumberGroup = new HashMap();
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    static {
        IntStream.rangeClosed(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER)
                .forEach(lottoNumber -> cachedLottoNumberGroup.put(lottoNumber, new LottoNumber(lottoNumber)));
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String lottoNumber) {
        return of(Integer.parseInt(lottoNumber));
    }

    public static LottoNumber of(int lottoNumber) {
        LottoNumber cachedLottoNumber = cachedLottoNumberGroup.get(lottoNumber);
        validateLottoNumber(cachedLottoNumber);
        return cachedLottoNumber;
    }

    private static void validateLottoNumber(LottoNumber cachedLottoNumber) {
        if (cachedLottoNumber == null) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
