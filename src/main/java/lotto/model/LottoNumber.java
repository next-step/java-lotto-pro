package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final String OUT_OF_RANGE_MESSAGE = "로또 범위를 벗어났습니다.";
    private final int number;

    public LottoNumber (String text) {
        this(Integer.parseInt(text));
    }

    public LottoNumber(int number) {
        if (validateNumber(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        this.number = number;
    }

    private boolean validateNumber(int number) {
        return number < START_NUMBER || number > END_NUMBER;
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
