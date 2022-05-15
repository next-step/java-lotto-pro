package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.Objects;

public class MatchCount {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 6;
    private final int matchCount;

    private MatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public static MatchCount from(int matchCount) {
        if (matchCount < MIN_COUNT || matchCount > MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_MATCH);
        }
        return new MatchCount(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
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
