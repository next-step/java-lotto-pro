package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lotto.view.OutputView;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> numberMap = new HashMap<>();

    static {
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            numberMap.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        validLottoNumber(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (numberMap.containsKey(number)) {
            return numberMap.get(number);
        }
        return new LottoNumber(number);
    }

    private static void validLottoNumber(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_LOTTO_NUMBER_1_TO_45);
        }
    }

    public int getNumber() {
        return number;
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
}
