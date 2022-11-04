package study.step3.domain.lottonumber;

import study.step3.message.LottoMessage;
import study.step3.util.Patterns;

public class LottoNumber {

    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberIsGreaterThanMinimum(lottoNumber);
        validateNumberIsLessThanMaximum(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumberIsGreaterThanMinimum(int lottoNumber) {
        if(lottoNumber < LOTTO_MINIMUM_NUMBER) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_IS_GREATER_THAN_MINIMUM.message());
        }
    }

    private void validateNumberIsLessThanMaximum(int lottoNumber) {
        if(lottoNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_IS_LESS_THAN_MAXIMUM.message());
        }
    }

    public static LottoNumber of(String lottoNumber) {
        validateNumber(lottoNumber);
        return new LottoNumber(Integer.parseInt(lottoNumber));
    }

    private static void validateNumber(String number) {
        validateIsNotEmpty(number);
        validateIsNumber(number);
    }

    private static void validateIsNotEmpty(String number) {
        if(number == null || number.isEmpty()) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_SHOULD_BE_NOT_EMPTY.message());
        }
    }

    private static void validateIsNumber(String number) {
        if(!Patterns.ONLY_NUMBERS.match(number)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_SHOULD_BE_NUMBER.message());
        }
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
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
