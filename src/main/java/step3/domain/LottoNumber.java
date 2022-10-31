package step3.domain;

import java.util.Objects;

public class LottoNumber {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    public static final String ERROR_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45의 숫자입니다. input : ";
    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    private void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
