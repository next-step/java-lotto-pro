package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();
    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = cache.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(String.format("%d에서 %d 사이의 숫자를 입력하세요", MIN_NUMBER, MAX_NUMBER));
        }
        return lottoNumber;
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number.trim()));
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
