package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private final int number;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, getMaxLottoNumber())
                .forEach(number -> lottoNumberCache.put(number, new LottoNumber(number)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (!lottoNumberCache.containsKey(number)) {
            throw new IllegalArgumentException("1~45의 숫자만 입력해주세요.");
        }
        return lottoNumberCache.get(number);
    }

    public static int getMaxLottoNumber() {
        return MAX_LOTTO_NUMBER;
    }

    public static int getMinLottoNumber() {
        return MIN_LOTTO_NUMBER;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
