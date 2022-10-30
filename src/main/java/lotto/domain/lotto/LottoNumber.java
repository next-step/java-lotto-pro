package lotto.domain.lotto;

import lotto.constant.LottoConstant;
import lotto.status.ErrorStatus;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = validateString(number);
    }

    private int validateString(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
        }
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
        }
        int convertNumber = Integer.parseInt(number);
        validate(convertNumber);
        return convertNumber;
    }

    private void validate(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
        }
        if (number > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
        }
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
