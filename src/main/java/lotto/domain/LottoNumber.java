package lotto.domain;

import java.util.Set;

public class LottoNumber {
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final String ERROR_VALID_NUMBER_RANGE_MESSAGE = "[ERROR] 1 ~ 45의 숫자만 입력가능합니다.";
    public static final String ERROR_BONUS_NUMBER = "[ERROR] 중복없이 6개의 숫자와 보너스볼 숫자를 입력해주세요.";

    public final int number;

    public LottoNumber(int number) {
        checkValidationNumber(number);
        this.number = number;
    }

    public LottoNumber(Set<Integer> numbers, int number) {
        checkValidationNumber(numbers, number);
        this.number = number;
    }

    private void checkValidationNumber(int number) {
        if (number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE)
            throw new IllegalArgumentException(ERROR_VALID_NUMBER_RANGE_MESSAGE);
    }

    private void checkValidationNumber(Set<Integer> numbers, int number) {
        if (numbers.contains(number))
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER);

        checkValidationNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}

