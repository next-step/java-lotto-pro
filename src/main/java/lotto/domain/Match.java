package lotto.domain;

import lotto.ConstantsKr;

import java.util.Objects;

public class Match {
    private final int value;

    public Match(int matchingCount) {
        validateBounds(matchingCount);
        this.value = matchingCount;
    }

    private void validateBounds(int value) {
        if (value < 0 || value > ConstantsKr.NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("당첨 번호 일치 개수는 0 ~ " + ConstantsKr.NUMBER_OF_LOTTO_NUMBERS + "입니다.");
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
        Match that = (Match) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
