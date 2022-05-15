package lotto.model;

import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        checkNumberRange(number);
        return new LottoNumber(number);
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            String message = String.format("[ERROR] 로또 번호는 %d와 %d 사이 입니다!", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
