package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.Objects;

public class MatchCount {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 6;
    private int matchCount;

    public MatchCount(int matchCount) {
        if (matchCount < MIN_COUNT || matchCount > MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_MATCH);
        }
        this.matchCount = matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
