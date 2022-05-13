package lotto;

import java.util.Objects;

public class LottoNumber {

    public static final int START_NUM = 1;
    public static final int LAST_NUM = 45;
    private final int number;

    private LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(final int number) {
        if (number > LAST_NUM || number < START_NUM) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
