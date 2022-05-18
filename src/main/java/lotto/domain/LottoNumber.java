package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final String LOTTO_NUMBER_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "숫자가 정상적인 범위를 벗어납니다.";
    private final int value;

    public LottoNumber(String lottoNumber) {
        validatePositive(lottoNumber);
        int value = Integer.parseUnsignedInt(lottoNumber);
        validateBounds(value);
        this.value = value;
    }

    public LottoNumber(int lottoNumber) {
        validateBounds(lottoNumber);
        this.value = lottoNumber;
    }

    public LottoNumber(String bonusLottoNumber, WinningNumbers winningNumbers) {
        validatePositive(bonusLottoNumber);
        int value = Integer.parseUnsignedInt(bonusLottoNumber);
        validateDuplicate(new LottoNumber(value), winningNumbers);
        this.value = value;
    }

    private void validatePositive(String lottoNumber) {
        try {
            Integer.parseUnsignedInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 자연수여야 합니다.");
        }
    }

    private void validateBounds(int lottoNumber) {
        if (lottoNumber < LottoNumberBounds.MIN.getValue() || lottoNumber > LottoNumberBounds.MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate(LottoNumber bonusLottoNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.has(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
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
