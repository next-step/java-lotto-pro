package lotto.domain;

import lotto.exception.ExceedNumberBoundException;
import lotto.ui.LottoMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.number = Integer.parseInt(lottoNumber);
    }

    public int getNumber() {
        return number;
    }

    private void validateLottoNumber(String lottoNumber) {
        int integerNumber = validateNumeric(lottoNumber);
        validateNumberBound(integerNumber);
    }

    private int validateNumeric(String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LottoMessage.WRONG_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateNumberBound(int integerNumber) {
        if (integerNumber < MIN_BOUND || integerNumber > MAX_BOUND) {
            throw new ExceedNumberBoundException(LottoMessage.WRONG_NUMBER_BOUND_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber otherLottoNumber = (LottoNumber) o;
        return number == otherLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return number - otherLottoNumber.number;
    }
}
