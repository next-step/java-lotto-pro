package lotto;

import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_START_NUMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        Validate.isNumber(String.valueOf(number));
        Validate.isOutOfBound(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return lottoNumbers.get(number);
    }

    public static LottoNumber from(String number) {
        return LottoNumber.from(Integer.parseInt(number));
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
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
