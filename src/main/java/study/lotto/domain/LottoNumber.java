package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private int lottoNumber;

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .forEach((num) -> lottoNumbers.put(num, new LottoNumber(num)));
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        if(Objects.isNull(lottoNumbers.get(number))) {
            throw new IllegalArgumentException("[ERROR] the given number is an invaild lotto number.");
        }
        return lottoNumbers.get(number);
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
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber target) {
        return Integer.compare(this.lottoNumber, target.lottoNumber);
    }
}
