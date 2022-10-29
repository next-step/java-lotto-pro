package lotto.domain;

import java.util.Objects;

public class MatchCount implements Comparable<MatchCount> {

    private static final int NUMBERS_WITH_BONUS = 5;
    private final int matchBallCount;
    private final int matchBonusBallCount;

    public MatchCount(final int matchBallCount, final int matchBonusBallCount) {
        this.matchBallCount = matchBallCount;
        this.matchBonusBallCount = matchBonusBallCount;
    }

    public Integer getCount() {
        return matchBallCount;
    }

    @Override
    public int compareTo(final MatchCount matchCount) {
        return Integer.compare(this.matchBallCount + this.matchBonusBallCount,
                matchCount.matchBallCount + matchCount.matchBonusBallCount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MatchCount that = (MatchCount) o;
        if (matchBallCount == NUMBERS_WITH_BONUS) {
            return Objects.equals(matchBallCount, that.matchBallCount)
                    && Objects.equals(matchBonusBallCount, that.matchBonusBallCount);
        }
        return Objects.equals(matchBallCount, that.matchBallCount);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + matchBallCount;
        return result;
    }
}
