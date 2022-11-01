package model;

import Utils.PatternUtils;
import exception.LottoNumberRangeException;
import exception.NotPositiveNumberException;

import java.util.Objects;

import static model.LottoPurchaseAmount.NOT_POSITIVE_NUMBER_ERROR_MESSAGE;

public class LottoNumber implements Number {
    public static final int MINIMUM_RANGE_NUMBER = 1;
    public static final int MAXIMUM_RANGE_NUMBER = 45;

    private static final String LOTTO_NUMBER_RAGNE_ERROR_MESSSAGE = "지정된 로또 숫자범위를 벗어났습니다.";

    private int number;

    public LottoNumber() {
    }

    public LottoNumber(String number) {
        if (!PatternUtils.isPositiveNumber(number)) {
            throw new NotPositiveNumberException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }

        validNumber(Integer.parseInt(number));
        this.number = Integer.parseInt(number);
    }

    public LottoNumber(int number) {
        validNumber(number);

        this.number = number;
    }

    private void validNumber(int number) {
        if (isNotRightNumber(number)) {
            throw new LottoNumberRangeException(LOTTO_NUMBER_RAGNE_ERROR_MESSSAGE);
        }

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

    private boolean isNotRightNumber(int number) {
        return MINIMUM_RANGE_NUMBER > number || number > MAXIMUM_RANGE_NUMBER;
    }
}
