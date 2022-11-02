package study.step4.models;

import study.step4.exception.LottoNumberOutOfRangeException;
import study.step4.helper.LottoNumbers;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int compare(LottoNumber number) {
        return this.number - number.getNumber();
    }

    private void validateNumberInRange(int number) {
        if (number > LottoNumbers.MAX_NUMBER || number < LottoNumbers.MIN_NUMBER) {
            throw new LottoNumberOutOfRangeException(
                    String.format("로또 숫자는 %d이상 %d이하의 숫자만 가능합니다.", LottoNumbers.MIN_NUMBER, LottoNumbers.MAX_NUMBER));
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
}
