package lotto.domain;

import java.util.Objects;

import static lotto.domain.ExceptionMessage.OUT_OF_BOUNDS;

public class Match {
    private final int value;

    public Match(int matchingCount) {
        validateBounds(matchingCount);
        this.value = matchingCount;
    }

    private void validateBounds(int value) {
        if (value < 0 || value > LottoGame.SIZE) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS.getMessage());
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
