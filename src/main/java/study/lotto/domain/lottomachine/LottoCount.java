package study.lotto.domain.lottomachine;

import java.util.Objects;

public class LottoCount {
    private final int value;

    public LottoCount(String stringValue) {
        this.value = validate(stringValue);
    }

    public LottoCount(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public boolean isGreaterThan(LottoCount number) {
        return value > number.value;
    }

    public LottoCount subtract(LottoCount number) {
        return new LottoCount(value - number.value);
    }

    private int validate(String price) {
        int parsedValue = parseNumber(price);
        if (parsedValue < 0) {
            throw new IllegalArgumentException("로또 수는 0보다 크거나 같아야 합니다.");
        }
        return parsedValue;
    }

    private int parseNumber(String priceString) {
        return Integer.parseInt(priceString);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
