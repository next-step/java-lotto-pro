package lotto.domain;

import java.util.Objects;

import static lotto.domain.ExceptionMessage.NOT_UNSIGNED_INT;
import static lotto.domain.ExceptionMessage.NUMBER_DUPLICATE;
import static lotto.domain.ExceptionMessage.OUT_OF_BOUNDS;

public class LottoNumber {
    private final int value;

    public LottoNumber(String lottoNumber) {
        validateUnsignedInt(lottoNumber);
        int value = Integer.parseUnsignedInt(lottoNumber);
        validateBounds(value);
        this.value = value;
    }

    public LottoNumber(int lottoNumber) {
        validateBounds(lottoNumber);
        this.value = lottoNumber;
    }

    public LottoNumber(String bonusLottoNumber, WinningNumbers winningNumbers) {
        validateUnsignedInt(bonusLottoNumber);
        int value = Integer.parseUnsignedInt(bonusLottoNumber);
        validateDuplicate(new LottoNumber(value), winningNumbers);
        this.value = value;
    }

    private void validateUnsignedInt(String lottoNumber) {
        try {
            Integer.parseUnsignedInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_UNSIGNED_INT.getMessage());
        }
    }

    private void validateBounds(int lottoNumber) {
        if (lottoNumber < LottoNumberBounds.MIN.getValue() || lottoNumber > LottoNumberBounds.MAX.getValue()) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS.getMessage());
        }
    }

    private void validateDuplicate(LottoNumber bonusLottoNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.has(bonusLottoNumber)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
