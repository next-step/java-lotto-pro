package lotto.domain;

import java.util.*;

import static lotto.domain.LottoNumberGenerator.MAX_NUMBER;
import static lotto.domain.LottoNumberGenerator.MIN_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = createLottoNumberCache();

    private final int number;

    public LottoNumber(String number) {
        try {
            number = number.trim();
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = LOTTO_NUMBER_CACHE.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지입니다.");
        }
        return lottoNumber;
    }

    private static Map<Integer, LottoNumber> createLottoNumberCache() {
        Map<Integer, LottoNumber> cache = new HashMap<>();
        for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
            cache.put(i, new LottoNumber(i));
        }
        return Collections.unmodifiableMap(cache);
    }

    @Override
    public int compareTo(LottoNumber another) {
        return Integer.compare(this.number, another.number);
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
