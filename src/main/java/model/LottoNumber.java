package model;

import exception.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber implements Number {
    private final int MINIMUM_RANGE_NUMBER = 1;
    private static final int MAXIMUM_RANGE_NUMBER = 45;

    private static final String LOTTO_NUMBER_RAGNE_ERROR_MESSSAGE = "지정된 로또 숫자범위를 벗어났습니다.";

    private int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        if (!isRightNumber(number)) {
            throw new LottoNumberRangeException(LOTTO_NUMBER_RAGNE_ERROR_MESSSAGE);
        }

        this.number = number;
    }

    public int getValue() {
        return this.number;
    }

    @Override
    public int getMaximumRangeNumber() {
        return MAXIMUM_RANGE_NUMBER;
    }

    @Override
    public int getMinimumRangeNumber() {
        return MINIMUM_RANGE_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((LottoNumber) obj).number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private boolean isRightNumber(int number) {
        return MINIMUM_RANGE_NUMBER <= number && number <= MAXIMUM_RANGE_NUMBER;
    }
}
