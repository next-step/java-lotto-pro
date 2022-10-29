package step3.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_NUMBER = 0;

    private final int value;

    public LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validation(int value) {
        if (value < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
