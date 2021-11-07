package lotto.model;

import java.util.Objects;

public class LottoNumber {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.value = value;
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
